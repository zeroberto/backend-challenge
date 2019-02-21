package com.invillia.acme.http.json;

/**
 * Json view groups.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface DefaultJsonView {

    /**
     * Interface representing the object rendering group for requests.
     */
    interface RequestJsonView extends DefaultJsonView {
    }

    /**
     * Interface that represents the object rendering group for responses.
     */
    interface ResponseJsonView extends DefaultJsonView {
    }

    /**
     * Interface that represents the object rendering group for PUT requests.
     */
    interface PutRequestJsonView extends DefaultJsonView {
    }

    /**
     * Interface representing the object rendering group for PATCH requests.
     */
    interface PatchRequestJsonView extends DefaultJsonView {
    }

    /**
     * Interface that represents the rendering group of objects that are
     * subtypes of others.
     */
    interface SubtypeResponseJsonView extends DefaultJsonView {
    }
}
