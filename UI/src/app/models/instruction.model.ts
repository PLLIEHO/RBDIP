import {PassportModel} from "./passport.model";

export interface InstructionModel extends PassportModel{
    eye_color: number,
    date_of_order: string,
    positive_negative_type: boolean,
    job_id: number,
    job_type_id: number
}
