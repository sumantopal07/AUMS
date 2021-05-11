import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import GraphData from 'src/app/Models/GraphData.Model';
import { TrendsService } from 'src/app/Services/TrendsService/trends.service';

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css'],
})
export class TrendsComponent implements OnInit {
  view: any[] = [700, 370];

  // options
  legendTitle = 'Products';
  legendTitleMulti = 'Months';
  legendPosition = 'below'; // ['right', 'below']
  legend = true;

  xAxis = true;
  yAxis = true;

  yAxisLabel = 'Sales';
  xAxisLabel = 'Products';
  showXAxisLabel = true;
  showYAxisLabel = true;

  maxXAxisTickLength = 30;
  maxYAxisTickLength = 30;
  trimXAxisTicks = false;
  trimYAxisTicks = false;
  rotateXAxisTicks = false;

  xAxisTicks: any[] = [
    'Genre 1',
    'Genre 2',
    'Genre 3',
    'Genre 4',
    'Genre 5',
    'Genre 6',
    'Genre 7',
  ];
  public client: any[];
  public skill: any[];
  public description: any[];
  public location: any[];

  animations = true; // animations on load

  showGridLines = true; // grid lines

  showDataLabel = true; // numbers on bars

  gradient = false;
  colorScheme = {
    domain: ['#704FC4', '#4B852C', '#B67A3D', '#5B6FC8', '#25706F'],
  };
  schemeType = 'ordinal'; // 'ordinal' or 'linear'

  activeEntries: any[] = ['book'];
  barPadding = 5;
  tooltipDisabled = false;

  yScaleMax = 1;

  roundEdges = false;
  onSelect(event: any): void {
    console.log(event);
  }

  onActivate(data: any): void {
    console.log('Activate', JSON.parse(JSON.stringify(data)));
  }

  onDeactivate(data: any): void {
    console.log('Deactivate', JSON.parse(JSON.stringify(data)));
  }

  formatString(input: string): string {
    return input.toUpperCase();
  }

  formatNumber(input: number): number {
    return input;
  }

  constructor(private trendService: TrendsService) {}
  ngOnInit() {
    this.trendService.skill().subscribe(
      (data) => {
        this.skill = [];
        data.forEach((i) => {
          this.skill.push({
            name: i.skill,
            value: i.total,
          });
        });
      },
      (error) => {}
    );
    this.trendService.client().subscribe(
      (data) => {
        this.client = [];
        data.forEach((i) => {
          this.client.push({
            name: i.client,
            value: i.total,
          });
        });
      },
      (error) => {}
    );

    this.trendService.location().subscribe(
      (data) => {
        this.location = [];
        data.forEach((i) => {
          this.location.push({
            name: i.location,
            value: i.total,
          });
        });
      },
      (error) => {}
    );

    this.trendService.description().subscribe(
      (data) => {
        this.description = [];
        data.forEach((i) => {
          this.description.push({
            name: i.description,
            value: i.total,
          });
        });
      },
      (error) => {}
    );
  }
}
