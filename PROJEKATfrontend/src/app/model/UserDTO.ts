import { UserRole } from './UserRole';
import { MagazineDTO } from './MagazineDTO';

export class UserDTO{
	id : String;
    name  :String;
	surname : String;
	password : String;
	password2 : String;
	email : String;
	roles : Array<UserRole>;
	magazine : MagazineDTO;
}