package TestSuite;
// test commit marilou
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Ecrans.EcranAccueil;
import Ecrans.EcranFirstPage;
import Ecrans.Reservations.EcranA_newResa;
import Ecrans.Reservations.EcranB_categorieVehicule;
import Ecrans.Reservations.EcranC_recapVehiculeEtChoixPaiement;
import Ecrans.Reservations.EcranD_recapResaFin;
import Generic.TestManager;


public class US2 extends TestManager {
		
			 
		// Lancer l'application = la page FirstPage est affichÃ©e
		// 1 Reserver Ã  la Page d' accueil sans se connecter
		@Test
		public void us2cdt1() throws InterruptedException { 

			EcranFirstPage eFirstPage = new EcranFirstPage();
			EcranAccueil eAccueil = new EcranAccueil();
			EcranA_newResa eResa = new EcranA_newResa();
			EcranB_categorieVehicule eCategorie = new EcranB_categorieVehicule();
			EcranC_recapVehiculeEtChoixPaiement ePaiement = new EcranC_recapVehiculeEtChoixPaiement();
			EcranD_recapResaFin eRecap = new EcranD_recapResaFin();
		 
			boolean eAfficheeOK;
						
			String agence="Paris";
			String dateDepart="29";
			String dateRetour="30";
			String heureDepart="12:00";
			String heureRetour="12:00";
					
				
			// 1 Cliquer sur Continuer en tant qu'invite
			eFirstPage.clickPoursuivreInvite();
			test.log(Status.INFO, "Affichage de la page d'accueil");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Click Poursuivre en tant qu invite   OK         |");			  
			System.out.println("|-------------------------------------------------------|");
			
			// 2 saisir Bordeaux pour rechercher une agence 
			eAccueil.clickBtnContinuer();  // param de confidentialite CONTINUER
			
			// eAfficheeOK = eAccueil.verifEcranAccueil();
			// Assert.assertTrue(eAfficheeOK);
			//test.log(Status.PASS, "Saisie nom de ville");
			
			eAccueil.remplirVilleAgence(agence);
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Page Accueil affichee 	OK                      |");
			System.out.println("|-------------------------------------------------------|");
			
			
			// 3 Selectionner Aeroport de Bordeaux BOD
			// selection de la premiere agence affiche ( aeroport) 
			eResa.selectAgence();
			test.log(Status.PASS, "Validation premiere agence");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Agence selectionnee   OK                        |");
			System.out.println("|-------------------------------------------------------|");
			
			// 4 Renseigner les dates et heures de debut et de fin
			eResa.clickBtnDate();
			
			eResa.selectDateDepart(dateDepart);
			test.log(Status.PASS, "Jour départ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Sélection jour depart   OK                      |");
			System.out.println("|-------------------------------------------------------|");	
			
			
			eResa.selectDateRetour(dateRetour);
			eResa.continuer();  
			test.log(Status.PASS, "Saisie des dates ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Saisie des dates   OK                           |");
			System.out.println("|-------------------------------------------------------|");
			eResa.selectHeureDepart(heureDepart);
			eResa.selectHeureRetour(heureRetour);   
			eResa.continuer();	
			test.log(Status.PASS, "Saisie des heures  ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Saisie des heures   OK                          |");
			System.out.println("|-------------------------------------------------------|");
			
			// 5 Verification page choix de la voiture 
			eAfficheeOK = eCategorie.verifPageCategorie();
			Assert.assertTrue(eAfficheeOK);
			test.log(Status.PASS, "Page Catégorie / choix du vehicule  ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Page Catégorie affichée   OK                    |");
			System.out.println("|-------------------------------------------------------|");
			
			// 6  selectionner un vehicule 
			eCategorie.coutTotal();
			
			eAfficheeOK = ePaiement.verifPagePaiement();
			Assert.assertTrue(eAfficheeOK);
			test.log(Status.PASS, "Page Options de paiement  ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Page options de paiement   OK                   |");
			System.out.println("|-------------------------------------------------------|");
			
			ePaiement.payerPlusTard();
			
			// 7 Verification page supplements
			eAfficheeOK = ePaiement.verifPageSupplement();
			Assert.assertTrue(eAfficheeOK);
			test.log(Status.PASS, "Page Supplement  ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Page Supplement   OK                            |");
			System.out.println("|-------------------------------------------------------|");
			
			ePaiement.continuer();
			
			// 8 Verification Page Verifier et reserver 
			eAfficheeOK = ePaiement.verifPageSupplement();
			Assert.assertTrue(eAfficheeOK);
			test.log(Status.PASS, "Page Recapitulatif  ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Page Recapitulatif    OK                        |");
			System.out.println("|-------------------------------------------------------|");

			// 8 affichage du recapitulatif de la reservation et annulation 
					
			eRecap.annulerResa();
			test.log(Status.PASS, "Annulation  ");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|Step : Annulation   OK                                 |");
			System.out.println("|-------------------------------------------------------|");
				
			
				
			
		}

}

