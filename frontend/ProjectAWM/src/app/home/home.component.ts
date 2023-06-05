import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Azienda } from '../classes/azienda';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  constructor(private userService:UserService){


  }

 aziende?:Azienda[]



  // ngOnInit è un metodo che viene chiamato SEMPRE all'inizio della creazione di una componente subito dopo il caricamento della grafica

  ngOnInit(): void {
    // Questa funzione lambda azienda fa si che il risultato della sottoscrizione all'observable venga inserito dentro l'array azienda

    this.userService.findAllAziende().subscribe(listaAziende=>{
      this.aziende=listaAziende
    }).add(()=>{
      console.log(this.aziende)
    })
  }


}
