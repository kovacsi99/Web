package app.core;

import app.error.BurgerNotFoundException;
import app.error.BurgerUnsupportedFieldPatchException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BurgerController {
    @Autowired
    private BurgerRepository burgerRepository;

    @GetMapping("/burgers")
    List<Burger> findAll()
    {
        return burgerRepository.findAll();
    }

    @PostMapping("/burgers")
    @ResponseStatus(HttpStatus.CREATED)
    Burger newBurger(@RequestBody Burger newBurger)
    {
        return burgerRepository.save(newBurger);
    }

    @GetMapping("/burgers/{id}")
    Burger findOne(@PathVariable Long id)
    {
        return burgerRepository
            .findById(id)
            .orElseThrow(() -> new BurgerNotFoundException(id));
    }

    @PutMapping("/burgers/{id}")
    Burger saveOrUpdate(@RequestBody Burger newBurger, @PathVariable Long id)
    {
        return burgerRepository.findById(id)
            .map(burger -> {
                burger.setName(newBurger.getName());
                burger.setNumberOfPatties(newBurger.getNumberOfPatties());
                burger.setVegetarian(newBurger.getVegetarian());
                burger.setUnitPriceInHuf(newBurger.getUnitPriceInHuf());

                return burgerRepository.save(burger);
            })
            .orElseGet(() -> {
                newBurger.setId(id);
                return burgerRepository.save(newBurger);
            });
    }

    @PatchMapping("/burgers/{id}")
    Burger patch(@RequestBody Map<String, String> update, @PathVariable Long id)
    {
        return burgerRepository.findById(id)
            .map(burger -> {
                HashSet<String> fieldSet = new HashSet<>();
                fieldSet.add("name");
                fieldSet.add("numberOfPatties");
                fieldSet.add("unitPriceInHuf");
                fieldSet.add("isVegetarian");

                for (String field : update.keySet()) {
                    if (!fieldSet.contains(field)) {
                        throw new BurgerUnsupportedFieldPatchException(update.keySet());
                    }
                }

                String name = update.get("name");
                if (!StringUtils.isEmpty(name)) {
                    burger.setName(name);
                }

                String numberOfPatties = update.get("numberOfPatties");
                if (!StringUtils.isEmpty(numberOfPatties)) {
                    burger.setNumberOfPatties(Integer.getInteger(numberOfPatties));
                }

                String unitPriceInHuf = update.get("unitPriceInHuf");
                if (!StringUtils.isEmpty(unitPriceInHuf)) {
                    burger.setUnitPriceInHuf(Integer.getInteger(unitPriceInHuf));
                }

                String isVegetarian = update.get("isVegetarian");
                if (!StringUtils.isEmpty(isVegetarian)) {
                    burger.setVegetarian(Boolean.getBoolean(isVegetarian));
                }

                return burgerRepository.save(burger);
            })
            .orElseGet(() -> {
                throw new BurgerNotFoundException(id);
            });
    }

    @DeleteMapping("/burgers/{id}")
    void deleteBurger(@PathVariable Long id)
    {
        burgerRepository.deleteById(id);
    }
}
