export class AdvancedQueryDTO{
    operation : String;
	field : Array<{item_id: String, item_text: String}>;
	query : boolean;
	isPhrase: Boolean;
}