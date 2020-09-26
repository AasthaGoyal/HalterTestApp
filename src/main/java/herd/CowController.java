package herd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;


@RestController
class CowController {

    private final CowRepository repository;

    CowController(CowRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/cows")
    CollectionModel<EntityModel<Cow>> all() {

        List<EntityModel<Cow>> cows = repository.findAll().stream()
                .map(cow -> new EntityModel<>(cow,
                        linkTo(methodOn(CowController.class).one(cow.getId())).withSelfRel(),
                        linkTo(methodOn(CowController.class).all()).withRel("cows")))
                .collect(Collectors.toList());

        return new CollectionModel<>(cows,
                linkTo(methodOn(CowController.class).all()).withSelfRel());
    }

    @PostMapping("/cows")
    Cow newCow(@RequestBody Cow newCow) {
        return repository.save(newCow);
    }

    // Single item

    @GetMapping("/cows/{id}")
    EntityModel<Cow> one(@PathVariable Long id) {

        Cow cow = repository.findById(id)
                .orElseThrow(() -> new CowNotFoundException(id));

        return new EntityModel<>(cow,
                linkTo(methodOn(CowController.class).one(id)).withSelfRel(),
                linkTo(methodOn(CowController.class).all()).withRel("cows"));
    }

    @PutMapping("/cows/{id}")
    Cow replaceCow(@RequestBody Cow newCow, @PathVariable Long id) {

        return repository.findById(id)
                .map(cow -> {
                    cow.setCowNumber(newCow.getCowNumber());
                    cow.setCollarId(newCow.getCollarId());
                    cow.setStatus(newCow.getStatus());
                    return repository.save(cow);
                })
                .orElseGet(() -> {
                    newCow.setId(id);
                    return repository.save(newCow);
                });
    }


}