/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protege_api;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 *
 * @author ALshmowkh
 */
public class OWL {

    public static void main(String[] args) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File("F:\\Master\\Thesis\\Implementations\\Ontologies\\pizza.owl"));
// Obtaining the location where an ontology was loaded from
        IRI documentIRI = manager.getOntologyDocumentIRI(ontology);
        System.out.println(" from: " + documentIRI);
//extracting the list of all axioms
        Set ax = ontology.getAxioms();
// Removing the prefix from the text
        Pattern pattern = Pattern.compile("http://(.+?)#");
        Iterator itlist = ax.iterator();
        while (itlist.hasNext()) {
            String result = itlist.next().toString();
//Removing the prefix
            Matcher matcherx = pattern.matcher(result);
            String temp = matcherx.replaceAll("");
            System.out.println(temp);
        }
    }
}
