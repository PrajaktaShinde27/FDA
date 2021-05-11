import { Item } from "./item";


export class Restaurant{
    constructor(
       public rid:number,
       public rname:string,
       public address:string,
       public contactNo:string,

       public item:Item
    ){}
}