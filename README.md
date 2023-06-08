

# Loyalty Platform IdS De Vitis - Caggiano

![Logo](https://s3.envato.com/files/269204463/loyalty-platform_inline_preview.jpg)

L’idea di questo progetto è aiutare tutte le attività ad incrementare il tasso di fidelizzazione,ritenere i clienti e acquisirne di nuovi.
La probabilità di vendere a un cliente esistente è compresa tra il 60% e il 70%, mentre a un potenziale nuovo cliente solo tra il 5% e il 20%.
Il target di riferimento sono attività locali con +2 stabilimenti.

Gli obiettivi principali sono:
- Aumentare il fatturato
- Ritenere i clienti
- Ottenere nuovi clienti grazie a quelli esistenti
- Costruire un Database qualificato

## FAQ

#### Chi interagisce con la piattaforma?

I soggetti principali che interagiranno con la piattaforma sono i seguenti:
1) Clienti.
2) Titolari dell'azienda che si vuole iscrivere alla Loyalty Platform.
3) Amministratori del punto vendita x dell'azienda y.
4) Dipendenti del punto vendita x.
#### Qual'è l'idea per fidelizzare il cliente?
L'azienda che si iscrive alla loyalty platform potrà effettuare una
fidelizzazione dei propri clienti attraverso l'adozione di uno dei programmi fedeltà offerti dalla piattaforma. L'azienda potrà infatti scegliere se sottoscrivere uno dei seguenti programmi:
1) Programma a punti
2) Programma a livelli
3) Programma membership esclusiva o VIP
4) Programma Cashback
5) Programma coalizione
#### Cosa caratterizza un programma a punti?
Un programma a punti è caratterizzato dall'introduzione di un 
sistema a punti che premierà il cliente in base all'importo degli acquisti compiuti all'interno dei punti vendita dell'azienda che adottano tale programma. Infatti più un cliente spenderà all'interno del negozio dell'azienda più punti egli accumulerà e di conseguenza potrà scegliere se spendere questi punti e scegliere dei premi presenti nel catalogo premi oppure continuare ad accumulare i suddetti punti.
#### Cosa caratterizza un programma a livelli?
Un programma a livelli è molto simile ad un programma a punti. Difatti più un cliente acquisterà all'interno del negozio più punti esperienza questo cliente otterrà. Tuttavia i punti esperienza servono per ottenere un nuovo livello di esperienza che offrirà al cliente degli sconti su determinati prodotti. Più il livello sarà alto più gli sconti saranno vantaggiosi.
#### Cosa caratterizza un programma VIP?
Un programma VIP è un programma a cui il cliente può aderire pagando un certo ammontare di denaro per ottenere una carta VIP. Questa carta fornirà sempre degli sconti al cliente che saranno molto vantaggiosi rispetto all'ammontare di denaro speso per la carta.
#### Cosa caratterizza un programma Cashback?
Un programma cashback utilizza il cashback per cercare di fidelizzare il cliente. Il cliente infatti compiendo acquisti all'interno del punto vendita riuscirà ad ottenere una piccola percentuale della spesa in cashback, per esempio se si spenderanno 100 euro all'interno del negozio si otterrà un cashback. Il rimborso è pari al 10% dell'importo di ogni transazione ed è calcolato sulla base del valore complessivo delle transazioni effettuate durante il Periodo di riferimento e rilevanti ai fini del Programmma. 
#### Cosa caratterizza una coalizione?
La coalizione è una specie di accordo tra aziende che fanno parte della Loyalty platform, per fidelizzare i propri clienti queste aziende forniscono sconti reciproci su determinati articoli.
#### Come posso io cliente sfruttare dei vantaggi del programma fedeltà?
Il cliente può accedere ai vantaggi del programma fedeltà sottoscrivendo il modulo di adesione presso uno dei punti vendita aderenti alla loyalty platform. Vi verrà poi attribuita una carta fedeltà contenente tutte le informazioni e i vari dati riguardanti essa. (Esempio: numero di punti posseduti, sconti, vantaggi, cashback ecc).
#### Come posso accedere alle informazioni sulle mie carte fedeltà?
Il cliente può accedere alle informazioni su tutte le proprie carte fedeltà all'interno della propria area riservata. Infatti vi è presente un portafoglio che è collegato univocamente ad un cliente e racchiude tutte le carte fedeltà del cliente con tutti i dati relativi ad esse. 




## Documentation

[Traccia progetto](https://drive.google.com/file/d/1fg07QJtRkYNSld_a-8ilBbCiUFEAGIMJ/view)




## API Reference


#### Titolare Azienda

- Inserisce un titolare Azienda all'interno della piattaforma.
```http
  POST localhost:8080/insertTitolareAzienda
```
- Ritorna la lista di tutti i titolari azienda all'interno della piattaforma.
```http
  GET localhost:8080/getTitolariAzienda
```
- Cancella un titolare azienda dalla piattaforma fornendo l'id del titolare azienda da cancellare.
```http
  DELETE localhost:8080/deleteTitolareAzienda/id
```
- Modifica un titolare azienda all'interno della piattaforma.
```http
  PUT localhost:8080/modifyTitolareAzienda/id
```
#### Azienda

- Inserisce un'azienda all'interno della piattaforma.
```http
  POST localhost:8080/insertAzienda
```
- Ritorna la lista di tutte le aziende all'interno della piattaforma.
```http
  GET localhost:8080/getAziende
```
- Rimuove una azienda dalla piattaforma fornendo l'id dell'azienda da cancellare.
```http
  DELETE localhost:8080/deleteAzienda/id
```
- Modifica un azienda all'interno della piattaforma.
```http
  PUT localhost:8080/modifyAzienda/id
```
#### Punto Vendita 

- Inserisce un punto vendita all'interno della piattaforma.
```http
  POST localhost:8080/insertPuntoVendita
```
- Ritorna la lista di tutti i punti vendita all'interno della piattaforma.
```http
  GET localhost:8080/getPuntiVendita
```
- Ritorna la lista di tutti i punti vendita all'interno della piattaforma che appartengono ad una data azienda.
```http
  GET localhost:8080/getPuntiVenditaByAzienda/id
```
- Rimuove una azienda dalla piattaforma fornendo l'id dell'azienda da cancellare.
```http
  DELETE localhost:8080/deleteAzienda/id
```
- Modifica un azienda all'interno della piattaforma.
```http
  PUT localhost:8080/modifyAzienda/id
```
#### Admin 

- Inserisce un admin all'interno della piattaforma.
```http
  POST localhost:8080/insertAdmin
```
- Ritorna la lista di tutti gli admin all'interno della piattaforma.
```http
  GET localhost:8080/getAdmins
```
- Ritorna l'admin di un punto vendita dato l'id del punto vendita.
```http
  GET localhost:8080/getAdminByPuntoVendita/1
```
- Cancella un admin dalla piattaforma dato l'id dell'admin da cancellare.
```http
  DELETE localhost:8080/deleteAdmin/id
```
- Modifica un admin all'interno della piattaforma.
```http
  PUT localhost:8080/modifyAdmin/id
```

#### Client

- Inserisce un cliente all'interno della piattaforma.
```http
  POST localhost:8080/insertClient
```
- Ritorna la lista di tutti i clienti all'interno della piattaforma.
```http
  GET localhost:8080/getClienti
```
- Ritorna la lista di tutti i clienti di un dato punto vendita.
```http
  GET localhost:8080/getClientiByPuntoVendita/id
```
- Cancella un cliente dalla piattaforma dato l'id del cliente da cancellare.
```http
  DELETE localhost:8080/deleteClient/id
```
- Modifica un cliente all'interno della piattaforma.
```http
  PUT localhost:8080/modifyClient/id
```

#### Dipendente

- Inserisce un dipendente all'interno della piattaforma.
```http
  POST localhost:8080/insertDipendente
```
- Cambia il dipendente in un admin presso il punto vendita in cui lavora.
```http
  POST localhost:8080/changeDipendenteToAdmin
```

- Ritorna la lista di tutti i dipendenti all'interno della piattaforma.
```http
  GET localhost:8080/getDipendenti
```
- Ritorna la lista di tutti i dipendenti di un dato punto vendita.
```http
  GET localhost:8080/getDipendentiByPuntoVendita/id
```
- Cancella un dipendente dalla piattaforma dato l'id del dipendente da cancellare.
```http
  DELETE localhost:8080/deleteDipendente/id
```
- Modifica un dipendente all'interno della piattaforma.
```http
  PUT localhost:8080/modifyDipendente/id
```
#### Carta Fedeltà

- Inserisce una carta fedeltà all'interno della piattaforma fornendo l'id del cliente.
```http
  POST localhost:8080/insertCartaFedelta/id
```
- Ritorna la lista di tutte le carte fedeltà all'interno della piattaforma.
```http
  GET localhost:8080/getCarteFedelta
```
- Ritorna la lista di tutte le carte fedeltà all'interno della piattaforma associate ad un cliente.
```http
  GET localhost:8080/getCarteFedeltaByClient/id
```
- Ritorna la lista di tutte le carte fedeltà all'interno della piattaforma di un cliente presso un punto vendita specifico.
```http
  GET localhost:8080/getCarteFedeltaByClientAndPuntoVendita/id/id
```

- Modifica il saldo cashback di un cliente in seguito alla richiesta di cashback, fornendo id carta e l'importo del cashback richiesto.
```http
  PUT localhost:8080/updateSaldoCashback/id/importo
```
- Cancella una carta fedelta dalla piattaforma dato l'id della carta da cancellare.
```http
  DELETE localhost:8080/deleteCartaFedelta/2
```
- Modifica una carta fedelta all'interno della piattaforma.
```http
  PUT localhost:8080/modifyCartaFedelta/id
```

#### Acquisto

- Inserisce un acquisto all'interno della piattaforma fornendo la carta fedeltà utilizzata per registrare l'acquisto.
```http
  POST localhost:8080/insertPurchase/id
```
Più tutte le api per operazioni crud e get specifiche.

#### Recensione

- Inserisce una recensione all'interno della piattaforma.
Se il cliente che vuole rilasciare una recensione per un punto vendita ed il cliente non ha effettuato nessun acquisto presso il punto vendita in questione verrà ritornato un messaggio di errore.

```http
  POST localhost:8080/insertRecensioneIfCliente
```
Più tutte le api per operazioni crud e get specifiche.

#### Tipo Comunicazione

- Inserisce un tipo di comunicazione all'interno della piattaforma.
```http
  POST localhost:8080/insertTipoComunicazionePromozionale
```
Più tutte le api per operazioni crud e get specifiche.

#### Comunicazione

- Inserisce una comunicazione da parte di un punto vendita alla lista dei suoi clienti. 
```http
  POST localhost:8080/insertComunicazione
```
Più tutte le api per operazioni crud e get specifiche.
## Authors

- [@Fabio De Vitis Michele](https://github.com/FabioDevIsTyping)
- [@Matteo Caggiano](https://github.com/caggicaggi)
## Strumenti utilizzati per il progetto
Per il progetto sono stati utilizzati:
- Spring Boot: Spring Boot è un framework open-source per lo sviluppo di applicazioni Java che semplifica notevolmente la creazione di applicazioni stand-alone e di servizi web. 
- Maven : Maven è una potente e popolare strumento di gestione delle dipendenze e di automazione del progetto per lo sviluppo di software Java. È un framework basato su plugin che semplifica notevolmente la gestione delle librerie esterne, la compilazione del codice, i test, il packaging e la distribuzione dell'applicazione.
- Visual Studio Code: Visual Studio Code è un editor di codice sorgente gratuito e altamente personalizzabile sviluppato da Microsoft. È un'applicazione leggera, multi-piattaforma e open-source che supporta numerosi linguaggi di programmazione ed è ampiamente utilizzata dagli sviluppatori per scrivere e debuggare il codice.
- Wampp server: 
WAMPP (Windows, Apache, MySQL, PHP, Perl) Server è un pacchetto di software che combina alcuni dei componenti essenziali per lo sviluppo e l'esecuzione di applicazioni web su un sistema Windows.
- Visual Paradigm: Visual Paradigm è un software di modellazione e progettazione visuale che supporta diverse metodologie e notazioni per la creazione di diagrammi e modelli. È ampiamente utilizzato nell'ambito dello sviluppo software e dell'ingegneria dei requisiti per visualizzare e comunicare in modo chiaro e strutturato l'architettura, il flusso di lavoro e i requisiti di un sistema o di un'applicazione.
- Postman: come frontend simulato. 
Postman è una popolare piattaforma di sviluppo di API che consente agli sviluppatori di creare, testare, documentare e condividere facilmente le API. È uno strumento versatile e potente utilizzato per semplificare il processo di sviluppo e integrazione delle API.
