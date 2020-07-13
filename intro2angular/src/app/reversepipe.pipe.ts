import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reversepipe'
})
export class ReversepipePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {

    console.log(value);
    return value;
  }

}
