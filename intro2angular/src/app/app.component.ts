import { Component } from '@angular/core';
import {RecordsService} from "./records.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  myvariable = 'app';
  title = 'intro2angular';
  // records:Object
  amount = 100.23;

  constructor(private myfirstservice: RecordsService) {
    this.myvariable = 'app';

  }

  ngOnInit(){
    // this.myfirstservice.getData().subscribe(data => {
    //   this.records = data.obj;
    // });
  }

  callmyfuntion() {
    this.myvariable = 'hey there'
  }

  updatevalue(e) {
    this.myvariable = e.target.value;
  }
}
