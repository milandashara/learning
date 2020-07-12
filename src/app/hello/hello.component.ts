import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  myvariable = 'milan'
  i = 0;
  constructor() { }

  ngOnInit(): void {
  }

  doSomeHeavyTask(){
    console.log(++this.i);
  }

}
