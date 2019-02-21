package com.invillia.acme.validation;

import com.invillia.acme.http.json.DefaultJsonView;

/**
 * Class containing the application validation groups for using javax.validation.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface DefaultValidationGroup {

    /**
     * Interface that represents the specific validation for the creation
     * of the validated object.
     */
    interface CreateValidationGroup extends RequestValidationGroup {
    }

    /**
     * Interface that represents the specific validation for the update
     * of the validated object.
     */
    interface UpdateValidationGroup extends DefaultValidationGroup {
    }

    /**
     * Interface that represents the specific validation for the partial update
     * of the validated object.
     */
    interface PartialUpdateValidationGroup extends DefaultValidationGroup {
    }

    /**
     * Interface that represents the specific validation for requests that modify
     * the validated object in some way.
     */
    interface RequestValidationGroup extends DefaultJsonView {
    }

    /**
     * Interface that represents the specific validation for requests that require the presence
     * of the sub-elements of the validated object.
     */
    interface SupertypeRequiredValidationGroup extends DefaultValidationGroup {
    }

    /**
     * Interface that represents the specific validation for the payment
     * of the validated object.
     */
    interface PaymentRequiredValidationGroup extends DefaultValidationGroup {
    }

    /**
     * Interface that represents the specific validation for the order items
     * of the validated object.
     */
    interface OrderItemsRequiredValidationGroup extends DefaultValidationGroup {
    }
}