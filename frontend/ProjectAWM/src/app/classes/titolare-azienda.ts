import { Azienda } from "./azienda"

export class TitolareAzienda {
    id?:number
    nome?:string
    cognome?:string 
    username?:string
    password?:string
    email?:string
    numeroTelefonico?:string
    aziende?:Azienda[]
}
