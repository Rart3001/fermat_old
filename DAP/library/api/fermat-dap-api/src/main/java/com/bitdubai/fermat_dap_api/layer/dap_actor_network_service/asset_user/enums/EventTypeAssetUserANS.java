/*
* @#EventType.java - 2015
* Copyright bitDubai.com., All rights reserved.
 * You may not modify, use, reproduce or distribute this software.
* BITDUBAI/CONFIDENTIAL
*/
package com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.enums;

import com.bitdubai.fermat_api.layer.all_definition.enums.Platforms;
import com.bitdubai.fermat_api.layer.all_definition.enums.interfaces.FermatEventEnum;
import com.bitdubai.fermat_api.layer.all_definition.events.interfaces.FermatEvent;
import com.bitdubai.fermat_api.layer.all_definition.events.interfaces.FermatEventListener;
import com.bitdubai.fermat_api.layer.all_definition.events.interfaces.FermatEventMonitor;
import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.events.CompleteClientAssetUserActorRegistrationNotificationEvent;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.events.CompleteRequestListRegisteredAssetUserActorNetworksNotificationEvent;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.listeners.CompleteClientAssetUserActorRegistrationNotificationEventListener;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.listeners.CompleteRequestListRegisteredAssetUserActorNetworksNotificationEventListener;


/**
 * The Class <code>com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.enums.EventType</code>
 * <p/>
 * Created by Hendry Rodriguez - (elnegroevaristo@gmail.com) on 11/10/15.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public enum EventTypeAssetUserANS implements FermatEventEnum {

    COMPLETE_REQUEST_LIST_COMPONENT_REGISTERED_NOTIFICATION("CL_RLCRN") {
        public FermatEventListener getNewListener(FermatEventMonitor eventMonitor) {
            return new CompleteRequestListRegisteredAssetUserActorNetworksNotificationEventListener(this, eventMonitor);
        }
        public FermatEvent getNewEvent() {
            return new CompleteRequestListRegisteredAssetUserActorNetworksNotificationEvent(this);
        }
    },
    COMPLETE_CLIENT_ASSET_USER_REGISTRATION_NOTIFICATION("CL_CAURN") {
        public FermatEventListener getNewListener(FermatEventMonitor eventMonitor) {
            return new CompleteClientAssetUserActorRegistrationNotificationEventListener(this, eventMonitor);
        }
        public FermatEvent getNewEvent() {
            return new CompleteClientAssetUserActorRegistrationNotificationEvent(this);
        }
    },


    ;


    /**
     * Represent the code of the message status
     */
    private final String code;

    /**
     * Constructor whit parameter
     *
     * @param code the valid code
     */
    EventTypeAssetUserANS(String code) {
        this.code = code;
    }


    public abstract FermatEventListener getNewListener(FermatEventMonitor fermatEventMonitor);

    public abstract FermatEvent getNewEvent();

    /**
     * Return the enum by the code
     *
     * @param code the valid code
     * @return EventType enum
     * @throws InvalidParameterException error with is no a valid code
     */
    public static EventTypeAssetUserANS getByCode(String code) throws InvalidParameterException {
        for (EventTypeAssetUserANS eventType : EventTypeAssetUserANS.values()) {
            if (eventType.code.equals(code)) {
                return eventType;
            }
        }
        throw new InvalidParameterException(InvalidParameterException.DEFAULT_MESSAGE, null, "Code Received: " + code, "This code isn't valid for the EventType Enum");
    }

    @Override
    public Platforms getPlatform() {
        return null;
    }

    @Override
    public String getCode() {
        return this.code;
    }


    @Override
    public String toString() {
        return getCode();
    }
}
