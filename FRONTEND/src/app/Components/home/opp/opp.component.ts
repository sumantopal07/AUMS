import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { AfterViewInit, ViewChild } from '@angular/core';

import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { OppurtunityService } from 'src/app/Services/CRUD Operations/oppurtunity.service';
import Opp from '../../../Models/OppModel.model';
import { DeleteComponent } from '../../DialogBox/delete/delete.component';
import { AddOppComponent } from '../../DialogBox/add-opp/add-opp.component';

@Component({
  selector: 'app-opp',
  templateUrl: './opp.component.html',
  styleUrls: ['./opp.component.css'],
})
export class OppComponent implements OnInit {
  displayedColumns: string[] = [
    'name',
    'location',
    'skills',
    'description',
    'client',
    'actions',
    'Min Experience',
    'Vacancies'
  ];
  opps: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  searchKey: string;
  noData = false;

  constructor(
    private dialog: MatDialog,
    private oppService: OppurtunityService
  ) {}

  ngOnInit(): void {
    this.getOpps();
  }
  onSearchClear(): void {
    this.searchKey = '';
    this.applyFilter();
  }

  applyFilter(): void {
    this.opps.filter = this.searchKey.trim().toLowerCase();
    this.noData = (this.opps.filteredData.length ===0)?true:false;
    if (this.opps.paginator) {
      this.opps.paginator.firstPage();
    }
  }

  onAddClick(): void {
    this.oppService.initializeFormGroup();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '50%';
    dialogConfig.data = {
      id: 1,
      title: 'Add New Grad',
    };
    this.dialog.open(AddOppComponent, dialogConfig);
    this.dialog.afterAllClosed.subscribe((res) => {
      this.getOpps();
    });
  }
  onUpdateClick(row): void {
    this.oppService.populateForm(row, row.oppId);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = {
      id: 3,
      title: 'Update Grad',
    };
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '50%';
    this.dialog.open(AddOppComponent, dialogConfig);
    this.dialog.afterAllClosed.subscribe((res) => {
      this.getOpps();
    });
  }
  onDeleteClick(opp): void {
    this.oppService.setId(opp);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '30%';
    this.dialog.open(DeleteComponent, dialogConfig);
    this.dialog.afterAllClosed.subscribe((res) => {
      this.getOpps();
    });
  }

  public getOpps(): void {
    this.oppService.getOpps().subscribe(
      (response: Opp[]) => {
        this.opps = new MatTableDataSource(response);
        this.opps.sort = this.sort;
        this.opps.paginator = this.paginator;
        this.opps.filterPredicate = (data: any, filter) => {
          console.log(filter,data);
          const dataStr = JSON.stringify(data).toLowerCase();
          return dataStr.indexOf(filter) !== -1;
        };
        this.noData= (this.opps._filterData.length ===0)?true: false;
      },
      (err: HttpErrorResponse) => {
        this.noData = true;
        this.opps =new MatTableDataSource();
      }
    );
  }
}
