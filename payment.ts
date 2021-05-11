import {Cart} from './cart';
export class Payment {
    constructor(
    public payment_id:number,
	public payment_mode:string,
	public total_cost:number,
    public dt:Date,
    //public dt:DatePipe,
    public cart:Cart,
          ){}
          
}