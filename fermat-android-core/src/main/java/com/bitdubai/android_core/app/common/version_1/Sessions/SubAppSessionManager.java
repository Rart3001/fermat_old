package com.bitdubai.android_core.app.common.version_1.Sessions;

import com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.SubAppsSession;
import com.bitdubai.fermat_api.layer.dmp_engine.sub_app_runtime.enums.SubApps;
import com.bitdubai.fermat_api.layer.modules.ModuleManager;
import com.bitdubai.fermat_cbp_api.layer.cbp_sub_app_module.crypto_broker_identity.interfaces.CryptoBrokerIdentityModuleManager;
import com.bitdubai.fermat_cbp_api.layer.cbp_sub_app_module.crypto_customer_identity.interfaces.CryptoCustomerIdentityModuleManager;
import com.bitdubai.fermat_ccp_api.layer.identity.intra_user.interfaces.IntraWalletUserIdentityManager;
import com.bitdubai.fermat_ccp_api.layer.module.intra_user.interfaces.IntraUserModuleManager;
import com.bitdubai.fermat_dap_android_sub_app_asset_factory_bitdubai.sessions.AssetFactorySession;
import com.bitdubai.fermat_dap_android_sub_app_asset_issuer_community_bitdubai.sessions.AssetIssuerCommunitySubAppSession;
import com.bitdubai.fermat_dap_android_sub_app_asset_issuer_identity_bitdubai.session.IssuerIdentitySubAppSession;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.sessions.AssetUserCommunitySubAppSession;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_identity_bitdubai.session.UserIdentitySubAppSession;
import com.bitdubai.fermat_dap_android_sub_app_redeem_point_community_bitdubai.sessions.AssetRedeemPointCommunitySubAppSession;
import com.bitdubai.fermat_dap_android_sub_app_redeem_point_identity_bitdubai.session.RedeemPointIdentitySubAppSession;
import com.bitdubai.fermat_dap_api.layer.dap_identity.asset_issuer.interfaces.IdentityAssetIssuerManager;
import com.bitdubai.fermat_dap_api.layer.dap_identity.asset_user.interfaces.IdentityAssetUserManager;
import com.bitdubai.fermat_dap_api.layer.dap_identity.redeem_point.interfaces.RedeemPointIdentityManager;
import com.bitdubai.fermat_dap_api.layer.dap_module.asset_factory.interfaces.AssetFactoryModuleManager;
import com.bitdubai.fermat_dap_api.layer.dap_sub_app_module.asset_issuer_community.interfaces.AssetIssuerCommunitySubAppModuleManager;
import com.bitdubai.fermat_dap_api.layer.dap_sub_app_module.asset_user_community.interfaces.AssetUserCommunitySubAppModuleManager;
import com.bitdubai.fermat_dap_api.layer.dap_sub_app_module.redeem_point_community.interfaces.RedeemPointCommunitySubAppModuleManager;
import com.bitdubai.fermat_pip_api.layer.pip_module.developer.interfaces.ToolManager;
import com.bitdubai.fermat_pip_api.layer.platform_service.error_manager.ErrorManager;
import com.bitdubai.fermat_wpd_api.layer.wpd_sub_app_module.wallet_factory.interfaces.WalletFactoryManager;
import com.bitdubai.fermat_wpd_api.layer.wpd_sub_app_module.wallet_publisher.interfaces.WalletPublisherModuleManager;
import com.bitdubai.fermat_wpd_api.layer.wpd_sub_app_module.wallet_store.interfaces.WalletStoreModuleManager;
import com.bitdubai.sub_app.crypto_broker_identity.session.CryptoBrokerIdentitySubAppSession;
import com.bitdubai.sub_app.crypto_customer_identity.session.CryptoCustomerIdentitySubAppSession;
import com.bitdubai.sub_app.developer.session.DeveloperSubAppSession;
import com.bitdubai.sub_app.intra_user_community.session.IntraUserSubAppSession;
import com.bitdubai.sub_app.intra_user_identity.session.IntraUserIdentitySubAppSession;
import com.bitdubai.sub_app.wallet_factory.session.WalletFactorySubAppSession;
import com.bitdubai.sub_app.wallet_publisher.session.WalletPublisherSubAppSession;
import com.bitdubai.sub_app.wallet_store.session.WalletStoreSubAppSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matias Furszyfer on 2015.07.20..
 */
public class SubAppSessionManager implements com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.SubAppSessionManager {

    private Map<SubApps, SubAppsSession> lstSubAppSession;


    public SubAppSessionManager() {
        lstSubAppSession = new HashMap<>();
    }


    @Override
    public Map<SubApps, SubAppsSession> listOpenSubApps() {
        return lstSubAppSession;
    }

    @Override
    public SubAppsSession openSubAppSession(SubApps subApps, ErrorManager errorManager, ModuleManager moduleManager) {
//                                            WalletFactoryManager walletFactoryManager,
//                                            ToolManager toolManager,
//                                            WalletStoreModuleManager walletStoreModuleManager,
//                                            WalletPublisherModuleManager walletPublisherManager,
//                                            IntraUserModuleManager intraUserCommunityModuleManager,
//                                            AssetFactoryModuleManager assetFactoryModuleManager,
//                                            CryptoBrokerIdentityModuleManager cryptoBrokerIdentityModuleManager,
//                                            CryptoCustomerIdentityModuleManager cryptoCustomerIdentityModuleManager,
//                                            IntraWalletUserIdentityManager intraWalletUserManager) {

        switch (subApps) {
            case CWP_WALLET_FACTORY:
                WalletFactorySubAppSession subAppSession = new WalletFactorySubAppSession(subApps, errorManager, (WalletFactoryManager) moduleManager);
                lstSubAppSession.put(subApps, subAppSession);
                return subAppSession;
            case CWP_WALLET_STORE:
                WalletStoreSubAppSession walletStoreSubAppSession = new WalletStoreSubAppSession(subApps, errorManager, (WalletStoreModuleManager) moduleManager);
                lstSubAppSession.put(subApps, walletStoreSubAppSession);
                return walletStoreSubAppSession;
            case CWP_DEVELOPER_APP:
                DeveloperSubAppSession developerSubAppSession = new DeveloperSubAppSession(subApps, errorManager, (ToolManager) moduleManager);
                lstSubAppSession.put(subApps, developerSubAppSession);
                return developerSubAppSession;
            case CWP_WALLET_MANAGER:
                break;
            case CWP_WALLET_PUBLISHER:
                WalletPublisherSubAppSession walletPublisherSubAppSession = new WalletPublisherSubAppSession(subApps, errorManager, (WalletPublisherModuleManager) moduleManager);
                lstSubAppSession.put(subApps, walletPublisherSubAppSession);
                return walletPublisherSubAppSession;
            case CWP_INTRA_USER_IDENTITY:
                IntraUserIdentitySubAppSession intraUserIdentitySubAppSession = new IntraUserIdentitySubAppSession(subApps, errorManager, (IntraWalletUserIdentityManager) moduleManager);
                lstSubAppSession.put(subApps, intraUserIdentitySubAppSession);
                return intraUserIdentitySubAppSession;
            case DAP_ASSETS_IDENTITY_ISSUER:
                IssuerIdentitySubAppSession issuerIdentitySession = new IssuerIdentitySubAppSession(subApps, errorManager, (IdentityAssetIssuerManager) moduleManager);
                lstSubAppSession.put(subApps, issuerIdentitySession);
                return issuerIdentitySession;
            case DAP_ASSETS_IDENTITY_USER:
                UserIdentitySubAppSession userIdentitySession = new UserIdentitySubAppSession(subApps, errorManager, (IdentityAssetUserManager) moduleManager);
                lstSubAppSession.put(subApps, userIdentitySession);
                return userIdentitySession;
            case DAP_REDEEM_POINT_IDENTITY:
                RedeemPointIdentitySubAppSession redeemPointSession = new RedeemPointIdentitySubAppSession(subApps, errorManager, (RedeemPointIdentityManager) moduleManager);
                lstSubAppSession.put(subApps, redeemPointSession);
                return redeemPointSession;
            case CCP_INTRA_USER_COMMUNITY:
                IntraUserSubAppSession intraUserSubAppSession = new IntraUserSubAppSession(subApps, errorManager, (IntraUserModuleManager) moduleManager);
                lstSubAppSession.put(subApps, intraUserSubAppSession);
                return intraUserSubAppSession;
            case DAP_ASSETS_FACTORY:
                AssetFactorySession assetFactorySession = new AssetFactorySession(subApps, errorManager, (AssetFactoryModuleManager) moduleManager);
                lstSubAppSession.put(subApps, assetFactorySession);
                return assetFactorySession;
            case DAP_ASSETS_COMMUNITY_ISSUER:
                AssetIssuerCommunitySubAppSession issuerCommunitySubAppSession =
                        new AssetIssuerCommunitySubAppSession(subApps, errorManager, (AssetIssuerCommunitySubAppModuleManager) moduleManager);
                lstSubAppSession.put(subApps, issuerCommunitySubAppSession);
                return issuerCommunitySubAppSession;
            case DAP_ASSETS_COMMUNITY_USER:
                AssetUserCommunitySubAppSession userCommunitySubAppSession =
                        new AssetUserCommunitySubAppSession(subApps, errorManager, (AssetUserCommunitySubAppModuleManager) moduleManager);
                lstSubAppSession.put(subApps, userCommunitySubAppSession);
                return userCommunitySubAppSession;
            case DAP_ASSETS_COMMUNITY_REDEEM_POINT:
                AssetRedeemPointCommunitySubAppSession redeemPointCommunitySubAppSession =
                        new AssetRedeemPointCommunitySubAppSession(subApps, errorManager, (RedeemPointCommunitySubAppModuleManager) moduleManager);
                lstSubAppSession.put(subApps, redeemPointCommunitySubAppSession);
                return redeemPointCommunitySubAppSession;
            case CBP_CRYPTO_BROKER_IDENTITY:
                CryptoBrokerIdentitySubAppSession cryptoBrokerIdentitySubAppSession = new CryptoBrokerIdentitySubAppSession(subApps, errorManager, (CryptoBrokerIdentityModuleManager) moduleManager);
                lstSubAppSession.put(subApps, cryptoBrokerIdentitySubAppSession);
                return cryptoBrokerIdentitySubAppSession;
            case CBP_CRYPTO_CUSTOMER_IDENTITY:
                CryptoCustomerIdentitySubAppSession cryptoCustomerIdentitySubAppSession = new CryptoCustomerIdentitySubAppSession(subApps, errorManager, (CryptoCustomerIdentityModuleManager) moduleManager);
                lstSubAppSession.put(subApps, cryptoCustomerIdentitySubAppSession);
                return cryptoCustomerIdentitySubAppSession;
            default:
                return null;
            //throw new FermatException("")
        }
        return null;
    }


    @Override
    public boolean closeSubAppSession(SubApps subApps) {
        try {
            lstSubAppSession.remove(new DeveloperSubAppSession(subApps));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public boolean isSubAppOpen(SubApps subApps) {
        return lstSubAppSession.containsKey(subApps);
    }

    @Override
    public SubAppsSession getSubAppsSession(SubApps subAppType) {
        return this.lstSubAppSession.get(subAppType);
    }


}
