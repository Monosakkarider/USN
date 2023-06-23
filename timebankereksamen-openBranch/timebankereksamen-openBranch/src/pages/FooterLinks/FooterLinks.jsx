import React from "react"
import './FooterLinks.css'
import { useRef } from "react"

const FooterLinks = () => {
    const toTop = (event) => {
        event.preventDefault();
        window.scrollTo({
            top: 0, behavior: 'smooth'
        });
    }
    const toBottom = (event) => {
        event.preventDefault();
        window.scrollTo({
            top: 10000, behavior: 'smooth'
        });
    }
  
        const aboutUsJump = useRef(null)
        const businessJump = useRef(null)
        const shippingJump = useRef(null)
        const returnJump = useRef(null)
        const sizesJump = useRef(null)
        
        const scrollToPageSectionOne =() => {
            window.scrollTo({
                top: aboutUsJump.current.offsetTop, behavior: 'smooth'
            });}
    
       /* const scrollToPageSectionTwo =() => {
        window.scrollTo({
            top: businessJump.current.offsetTop, behavior: 'smooth'
        });} */

        const scrollToPageSectionThree = () => {
            window.scrollTo({
                top: shippingJump.current.offsetTop, behavior: 'smooth'
            })}

        const scrollToPageSectionFour = () => {
            window.scrollTo({
                top: returnJump.current.offsetTop, behavior: 'smooth'
            })}
        const scrollToPageSectionFive = () => {
            window.scrollTo({
                top: sizesJump.current.offsetTop, behavior: 'smooth'
            })}
    
    
    return (
        <div className="footerLinks">
            <div className="faq-box">
                <nav>
                <a href="#stage1" onClick={toTop} className="faq-small-box">↑ Til topp ↑ </a>
                <a href="#aboutUs" onClick={scrollToPageSectionOne} className="faq-small-box">Om oss</a>
                {/* <a href="#forBusiness" onClick={scrollToPageSectionTwo} className="faq-small-box">For bedrift</a> */}
                <a href="#shipping" onClick={scrollToPageSectionThree}className="faq-small-box">Frakt</a>
                <a href="#return" onClick={scrollToPageSectionFour} className="faq-small-box">Retur</a>
                <a href="#sizes" onClick={scrollToPageSectionFive}className="faq-small-box">Størrelser</a>
                <a href="#bottom" onClick={toBottom}className="faq-small-box">↓ Til bunn ↓ </a>
                </nav>
            </div>

            
            <div className="BoxContainer">
            <div ref={aboutUsJump} style={{paddingTop:'5em'}}>  
                <section ref={aboutUsJump}></section>
            </div>  

            <div id="aboutUsLink" style={{paddingTop:'5em'}}></div>
                <div className="TitleBox">
                <span><h1 className="aboutUs">Om oss</h1></span>
                    </div>
                <div className="TextBox">
                        <span>
                        Skognes Padel, ditt førstevalg for alt av padel-utstyr og klær. Vi er stolte av å være et av Norges få nettbutikk innen padel, og vi er 
                        dedikert til å gi deg den aller beste padel-opplevelsen, med fokus på kvalitet, kundeservice og unike produkter.
                
                        <br/><br/>
                        Skognes Padel ble etablert i 2022, med en lidenskap for sporten padel og et ønske om å bringe de beste internasjonale padel-merkene til Norge. V
                        i jobber tett sammen med produsenter for å tilby et bredt utvalg av padel-racketer, sko, klær og tilbehør av høy kvalitet.
                        <br/><br/> 
                        i vet at hver padel-spiller er unik, og vi streber etter å tilby produkter som passer for alle, fra nybegynnere til erfarne spillere. Vårt engasjerte team har omfattende 
                        kunnskap om padel-utstyr og er alltid klare til å hjelpe deg med å velge de beste produktene for ditt behov. Vi inviterer deg til å utforske vårt omfattende utvalg av padel-produkter. Takk for at du støtter 
                        Skognes Padel, og for at du er en del av vår padel-familie.
                        <br/><br/>
                        Sving deg inn i spillet med Skognes Padel – din padel-partner!

                            
                        </span>   
                </div>

            {/* <div ref={businessJump} style={{paddingTop:'5em'}}>  
                <section ref={businessJump}></section>
            </div>  */}

                {/* <div id="forBusinessLink" style={{paddingTop:'5em'}}></div>
                <div className="TitleBox">
                <span><h1 className="forBusinesses">For bedrift</h1></span>
                
                    </div> */}
                {/* <div className="TextBox">
                        <span>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed gravida interdum placerat. 
                            Nulla viverra iaculis mauris, eget commodo massa dictum viverra. Aliquam erat volutpat. 
                            Fusce sed magna ut quam sollicitudin sodales vel quis dolor. In maximus mi quis lorem gravida, 
                            quis dictum mi ultricies. 
                            <br/><br/>
                            Suspendisse ut velit nec orci ornare ultrices ut et tortor. 
                            Praesent a diam at ipsum facilisis aliquet. In fringilla luctus pulvinar. Donec purus dui, s
                            agittis ut vestibulum a, hendrerit Nunc suscipit ullamcorper elit, a blandit ex rhoncus sed. 
                            Ut sodales quis tortor et pulvinar. Nulla mi purus, dictum sit amet interdum id, volutpat id dui. 
                            Nulla facilisi. Pellentesque vitae nulla id metus accumsan finibus id id nisi. Pellentesque vulputate commodo ex ut facilisis.
                            Donec sit amet mollis magna. Nullpam molestie tortor vitae tortor sollicitudin molestie. Vivamus id nunc mauris. 
                            Phasellus ac orci nisl.
                            <br/><br/> 
                            Nulla accumsan fringilla mauris eget rhoncus. Nunc rhoncus tempor facilisis. 
                            Fusce eget urna tincidunt, bibendum arcu in, semper purus. 
                             Suspendisse posuere quam non gravida dignissim. Etiam et magna sit amet mauris rutrum pretium. 
                            Aenean rhoncus lectus vel metus
                            
                        </span>   
                </div> */}

                <div ref={shippingJump} style={{paddingTop:'5em'}}>  
                    <section ref={shippingJump}></section>
                </div>

                <div id="shippingLink"style={{paddingTop:'5em'}}></div>
                <div className="TitleBox">
                <span><h1>Frakt</h1></span>
                    </div>
                <div className="TextBox">
                        <span>
                        Vi i Skognes Padel ønsker å gi deg en smidig og effektiv leveringsprosess. Derfor tilbyr vi gratis frakt på alle ordrer over 2000 kr. 
                        For ordrer under dette beløpet vil en standard eller ekspress fraktavgift bli lagt til din ordre ved utsjekk.
                            <br/><br/>
                            Med standard frakt kan du forvente å motta din bestilling hvor som helst i Norge innen 7 arbeidsdager. 
                            Vi jobber tett med pålitelige logistikkpartnere for å sikre at bestillingen din kommer trygt frem til døren din. 
                            For de som trenger sine padel-varer raskere, tilbyr vi et ekspressalternativ. Dette reduserer leveringstiden til bare 3 arbeidsdager. 
                            Ekspressfrakt vil ha en ekstra kostnad, som vil bli beregnet og vist ved utsjekk.

                            Vi setter pris på din forståelse av at fraktganger kan variere på grunn av eksterne faktorer. Men vær trygg på at vi alltid jobber for å få 
                            bestillingen din levert så raskt og effektivt som mulig.
                            <br/><br/> 
                            Skognes Padel - bringer padel til deg, hvor som helst, når som helst.
                            
                        </span>   
                </div>
                
                <div ref={returnJump} style={{paddingTop:'5em'}}>  
                    <section ref={returnJump}></section>
                </div>

                <div id="returnLink" style={{paddingTop:'5em'}}></div>
                <div className="TitleBox">
                    <span><h1 className="return">Retur</h1></span>
                </div>
                <div className="TextBox">
                        <span>
                        Hos Skognes Padel, så forstår vi at det av og til kan være nødvendig å returnere et produkt. 
                        Enten du har ombestemt deg, eller det er et problem med produktet du har mottatt, vi er her for å hjelpe.
                            <br/><br/>
                            Vi tilbyr en 14-dagers angrerett på alle produkter kjøpt på nettstedet vårt. Dette betyr at du kan returnere et produkt innen 14 dager etter mottakelse, 
                            forutsatt at produktet er i samme stand som da du mottok det, og med all emballasje intakt.
                            Hvis du mottar et produkt som er defekt eller skadet ved levering, vil vi gjerne hjelpe deg med å løse problemet. 
                            Vennligst send oss en e-post med beskrivelse av problemet, sammen med ditt ordrenummer.
                            For å starte returprosessen, send oss en e-post til retur@skognespadel.no med følgende informasjon:
                            <br/><br/>
                            1. Ditt ordrenummer
                            <br/><br/>
                            2. Navn på produktet du ønsker å returnere
                            <br/><br/>
                            3. Årsaker til retur
                            <br/><br/>

                            Etter at vi har mottatt e-posten din og bekreftet at returkravene er oppfylt, vil vi sende deg et returskjema via e-post. Fyll ut skjemaet, 
                            følg instruksjonene for retur, og send produktet tilbake til oss.
                        
                            Vi takker for forståelsen og tålmodigheten din gjennom denne prosessen. Hos Skognes Padel er vi dedikerte til å gi deg den beste kundeopplevelsen, 
                            og din tilfredshet er vår høyeste prioritet.
                            
                        </span>   
                </div>

                <div ref={sizesJump} style={{paddingTop:'5em'}}>  
                    <section ref={sizesJump}></section>
                </div>

                <div id="sizesLink" style={{paddingTop:'5em'}}></div>
                <div className="TitleBox">
                <span><h1 className="sizes">Størrelser</h1></span>
                    </div>
                <   div className="TextBox">
                        <span>
                        Å finne riktig størrelse er viktig for din komfort og ytelse. 
                        Hos Skognes Padel tilbyr vi et bredt utvalg av størrelser for å passe alle våre kunder.
                            <br/><br/>
                            <b>Sko</b>
                            <br/><br/>
                            Våre padel-sko følger standard europeiske skostørrelser. Vi tilbyr størrelser fra 38 til 45. Hvis du ikke er sikker på din skostørrelse, 
                            anbefaler vi at du måler foten din 
                            og bruker en skostørrelse guide tilgjengelig på nettet for å finne den mest nøyaktige størrelsen.
                            <br/><br/>
                            <b>Klær</b>
                            <br/><br/>
                            Våre sportsklær kommer i størrelser fra XS til XL. Vi anbefaler at du måler kroppen din nøyaktig før du bestiller for å sikre at du velger riktig størrelse. Hvis du er usikker, 
                            vennligst referer til vår størrelsesguide for klær, eller kontakt oss for mer hjelp.
                            <br/><br/>
                            <b>Padel racketer</b>
                            <br/><br/>
                            Våre padel-racketer er tilgjengelige i størrelser fra XS til XL. Størrelsen på padel-racketer refererer til grepsstørrelsen. En større grepsstørrelse kan gi mer kontroll, mens en mindre grepsstørrelse kan gi mer manøvrerbarhet. 
                            Valget av grepsstørrelse vil i stor grad avhenge av din personlige preferanse og spillestil.

                            <br/><br/>
                            Vi håper denne guiden hjelper deg med å finne den perfekte passformen for ditt padel-utstyr og klær. 
                            Hvis du har noen spørsmål, vennligst ikke nøl med å kontakte oss. Vi er her for å hjelpe!
                            
                        </span>   
                </div>
            </div>  
        </div>
    )
}

export default FooterLinks