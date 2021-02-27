package Criteria;


import Item.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AndCriteriaBidsTest{

    @Test
    public void checkCriteriaTest() {
        Item zapas = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        zapas.add(new Bid("9.4", 995));
        zapas.add(new Ask("6", 600));
        zapas.add(new Ask("8.4", 333));
        zapas.add(new Bid("4", 652));
        zapas.add(new Sale("8", 327));
        zapas.add(new Ask("9", 111));
        zapas.add(new Sale("9.5", 222));
        zapas.add(new Sale("10", 987));

        Criteria criteriaBids = new Bids();
        Criteria criteriaSize = new Size("9.5");
        AndCriteria sizeAndsales = new AndCriteria(criteriaBids, criteriaSize);

        List<Offer> resultado = sizeAndsales.checkCriteria(zapas);
        Offer hola = resultado.get(0);
        assertEquals(995, hola.value());
    }
}