import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portales',
  templateUrl: './portales.component.html',
  styleUrls: ['./portales.component.scss']
})
export class PortalesComponent implements OnInit {

  constructor() { }

  getLocalStorage(key){
    return localStorage.getItem(key);
  }

  ngOnInit() {
  }

}
