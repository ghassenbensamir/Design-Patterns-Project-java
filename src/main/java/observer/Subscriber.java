package observer;

import core.Session;

public interface Subscriber {
    void update(Session s);
}
