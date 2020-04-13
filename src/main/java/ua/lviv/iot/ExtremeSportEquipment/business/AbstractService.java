package ua.lviv.iot.ExtremeSportEquipment.business;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.model.AbstractExtremeSportEquipment;

@Service
public abstract class AbstractService<T> {

    protected abstract JpaRepository<T, Integer> getRepository();

    public List<T> getAll() {
        List<T> list = getRepository().findAll();
        for (T t : list) {
            System.out.println(t);
        }
        return getRepository().findAll();
    }

    public T getById(int id) {

        if (getRepository().existsById(id)) {
            System.out.println(getRepository().getOne(id));
            T t = (T) getRepository().getOne(id);
            return t;
        }

        return null;
    }

    public boolean deleteById(int id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }

    public T update(T t) {
        T previous = null;
        if (getRepository().existsById(((AbstractExtremeSportEquipment) t).getId())) {
            previous = getRepository().getOne(((AbstractExtremeSportEquipment) t).getId());
            getRepository().save(t);
        }
        return previous;
    }

    public T add(T t) {
        return getRepository().save(t);
    }

}
