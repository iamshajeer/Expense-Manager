package com.droidev.util.expensetracker.network;

import android.content.Context;
import com.droidev.util.expensetracker.BuildConfig;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.utils.Constants;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by shajeer on 25/2/16.
 */
public class RestClient {

    private static final String HEADER_APP_VERSION_CODE = "app-version-code";
    private static final String HEADER_MOBILE_OS = "client-os";
    private static final String HEADER_APP_VERSION = "app-version";

    private final RestAdapter REST_ADAPTER_AUTH_HEADER;

    public RestClient(Context context) {

        OkClient okClient = getOkClient();

        String baseUrl = context.getString(R.string.base_url);
        REST_ADAPTER_AUTH_HEADER = buildRestAdapter(baseUrl, new AuthRequestInterceptor
                (context));
    }

    private RestAdapter buildRestAdapter(String baseUrl, AuthRequestInterceptor
            authRequestInterceptor) {

        return new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setRequestInterceptor(authRequestInterceptor)
                .build();
    }

    public OkClient getOkClient() {
        return null;
    }

    private class CommonRequestInterceptor implements RequestInterceptor {

        public CommonRequestInterceptor() {
        }

        @Override
        public void intercept(RequestFacade request) {
            request.addHeader(HEADER_MOBILE_OS, Constants.MOBILE_OS);
            request.addHeader(HEADER_APP_VERSION, BuildConfig.VERSION_NAME);
            request.addHeader(HEADER_APP_VERSION_CODE, String.valueOf(BuildConfig.VERSION_CODE));
        }
    }

    private class AuthRequestInterceptor extends CommonRequestInterceptor {

        private final Context mContext;

        public AuthRequestInterceptor(Context context) {
            mContext = context;
        }

        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            super.intercept(request);
/*            HashMap<String, Object> userPrefMap = (HashMap<String, Object>) PreferenceHelper
                    .getUserPrefMap(mContext);
            if (userPrefMap != null) {
                String userCommonId = (String) userPrefMap.get(UserPreferenceUtils
                        .KEY_PREF_USER_COMMON_ID);
                String sessionId = (String) userPrefMap.get(UserPreferenceUtils
                        .KEY_PREF_SESSION_ID);
                request.addHeader(HEADER_USER_COMMON_ID, userCommonId);
                request.addHeader(HEADER_SESSION_ID, sessionId);
            }*/
        }
    }


}
