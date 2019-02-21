package com.invillia.acme.validation;

import com.invillia.acme.http.json.DefaultJsonView;

public interface DefaultValidationGroup {
    interface CreateValidationGroup extends RequestValidationGroup {
    }

    interface UpdateValidationGroup extends DefaultValidationGroup {
    }

    interface PartialUpdateValidationGroup extends DefaultValidationGroup {
    }

    interface RequestValidationGroup extends DefaultJsonView {
    }

    interface SupertypeRequiredValidationGroup extends DefaultValidationGroup {
    }

    interface PaymentRequiredValidationGroup extends DefaultValidationGroup {
    }

    interface OrderItemsRequiredValidationGroup extends DefaultValidationGroup {
    }
}