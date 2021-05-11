import { Component, OnInit, Inject } from '@angular/core';
import { OppurtunityService } from 'src/app/Services/CRUD Operations/oppurtunity.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/Services/Notification/notification.service';
import { OppComponent } from '../../home/opp/opp.component';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-opp',
  templateUrl: './add-opp.component.html',
  styleUrls: ['./add-opp.component.css'],
})
export class AddOppComponent implements OnInit {
  title: string;
  dId: any = 0;
  constructor(
    public oppService: OppurtunityService,
    public dialogRef: MatDialogRef<OppComponent>,
    private notificationService: NotificationService,
    @Inject(MAT_DIALOG_DATA) data
  ) {
    this.title = data.title;
    this.dId = data.id;
  }
 
  ngOnInit(): void {

  }
  getToday(): string {
    return new Date().toISOString().split('T')[0]
 }

  onClear(): void {
    this.oppService.form.reset();
    this.oppService.initializeFormGroup();
  }
  onSubmit(): void {
    if (this.oppService.form.valid) {
      if (!this.oppService.form.get('id').value) {
        console.log('nokey');
        this.oppService.addOpps(this.oppService.form.value).subscribe((res) => {
          console.log(res);
          this.refresh();
        });
        this.refresh();
      } else {
        this.oppService
          .updateOpps(this.oppService.form.value)
          .subscribe((res) => {
            console.log(res);
            this.refresh();
          });
        this.refresh();
      }
    }
  }

  onClose(): void {
    this.oppService.form.reset();
    this.oppService.initializeFormGroup();
    this.dialogRef.close();
  }
  refresh(): void {
    this.notificationService.success(
      'Updated successfully Refresh Page if Change not reflected'
    );
    this.onClose();
  }
}
