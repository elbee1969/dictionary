package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    /*
     * @GetMapping("/hello") public String hello() { return "Hello world!"; }
     *
     * @GetMapping("/greetings") public ArrayList<String> greetings() {
     * ArrayList<String> greetings = new ArrayList<>();
     * greetings.add("Bonjour"); greetings.add("Hello"); return greetings;
     *
     * }
     */

    @GetMapping("/{id}")
    public Invoice getOne(@PathVariable("id") Long id) { // Long pour null si
							 // vide sinon long pour
							 // = 0 si vide
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 100.36);
	invoice.setId(id);
	invoice.setPaid(true);
	return invoice;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("{}");
	return builder.toString();
    }

    @GetMapping()
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size = " + size + ", page = " + page);
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice1 = new Invoice("A02", date, 50.00);
	Invoice invoice2 = new Invoice("A03", date, 150.00);
	ArrayList<Invoice> invoices = new ArrayList<>();
	invoices.add(invoice1);
	invoices.add(invoice2);
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id " + id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println("invoice create : " + invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody @Valid Invoice invoice) {
	System.out.println("invoice update : " + invoice);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("invoice Patch paid : " + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("invoice Patch unpaid : " + id);
    }
}
