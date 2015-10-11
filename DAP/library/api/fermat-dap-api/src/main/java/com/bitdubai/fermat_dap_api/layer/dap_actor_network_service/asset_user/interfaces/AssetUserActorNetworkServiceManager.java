package com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.components.interfaces.PlatformComponentProfile;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.exceptions.CantConnecToException;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.exceptions.CantRegisterActorAssetUserException;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.exceptions.CantRequestListActorAssetUserRegisteredException;
import com.bitdubai.fermat_dap_api.layer.dap_actor_network_service.asset_user.exceptions.CantSendMessageException;
import com.bitdubai.fermat_dap_api.layer.dap_actor.asset_user.interfaces.ActorAssetUser;

/**
 * Created by root on 07/10/15.
 */
public interface AssetUserActorNetworkServiceManager {


    public void registerActorAssetUser(ActorAssetUser actorAssetUserToRegister) throws CantRegisterActorAssetUserException;

    public void requestListActorAssetUserRegistered()  throws CantRequestListActorAssetUserRegisteredException;

    public void connectTo(PlatformComponentProfile actorAssetUser)  throws CantConnecToException;

    public void sendMessage(ActorAssetUser actorAssetUser, String msjContent)  throws CantSendMessageException;

}
