import {PassportModel} from "./passport.model";

export interface CriminalModel extends PassportModel{
    fingerprint: number,
    eye_color: number
}
