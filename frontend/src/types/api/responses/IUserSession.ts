import type { IUser } from './IUser';

export interface IUserSession extends IUser {
  validUntil: Date;
  jwt: string;
}
