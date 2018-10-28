import { Owner } from './owner';
import { Currency } from './currency';

export class Keypart {
  id: number;
  payload: number[];
  owner: Owner[];
  currency: Currency;
  uuid: String;
}
