package herd;

class CowNotFoundException extends RuntimeException {

    CowNotFoundException(Long id) {
        super("Could not find cow " + id);
    }
}