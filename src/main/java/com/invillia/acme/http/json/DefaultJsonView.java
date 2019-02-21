package com.invillia.acme.http.json;

/**
 * Json view groups.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface DefaultJsonView {
    interface RequestJsonView extends DefaultJsonView {
    }

    interface ResponseJsonView extends DefaultJsonView {
    }

    interface PutRequestJsonView extends DefaultJsonView {
    }

    interface PatchRequestJsonView extends DefaultJsonView {
    }

    interface SubtypeResponseJsonView extends DefaultJsonView {
    }
}
