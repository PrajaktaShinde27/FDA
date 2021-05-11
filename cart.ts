import {Item} from './item';
export class Cart {
    constructor(
        public cart_id:number,
        public total_cost:number,
        public item:Item,
              ){}
}
