import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

interface MyDataInterface {

  obj: Object;

}

@Injectable({
  providedIn: 'root'
})
export class RecordsService {

  constructor(private httpClient:HttpClient) { }

  getData(){

    return this.httpClient.get<MyDataInterface>('/api/file.json');

  }
}
