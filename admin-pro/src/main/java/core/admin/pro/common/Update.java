package core.admin.pro.common;

import java.io.Serializable;

public class Update implements Serializable {


    /**
     * appName : TestUpdate
     * versionCode : 1
     * versionName : 1.0
     * apkUrl : http://java.linuxlearn.net/shelwee/Finances.apk
     * changeLog : 1.修复xxx Bug;
     2.更新UI界面.
     * updateTips : 更新提示
     */

    private String appName;
    private String versionCode;
    private String versionName;
    private String apkUrl;
    private String changeLog;
    private String updateTips;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    public String getUpdateTips() {
        return updateTips;
    }

    public void setUpdateTips(String updateTips) {
        this.updateTips = updateTips;
    }
}
