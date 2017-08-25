#!/bin/bash

# CHANGE THESE
app_package="phone.safe.lx.com.safephone"
dir_app_name="SafePhone"

ADB="adb" # how you execute adb
$ADB_SH="$ADB shell" # this script assumes using `adb root`. for `adb su` see `Caveats`
path_sysapp="/system/priv-app" # assuming the app is priviledged
apk_host="./app/build/outputs/apk/app-debug.apk"
apk_name=$dir_app_name".apk"
apk_target_dir="$path_sysapp"
apk_target_sys="$apk_target_dir/$apk_name"

# Delete previous APK
rm -f $apk_host

# Compile the APK: you can adapt this for production build, flavors, etc.
./gradlew assembleDebug || exit -1 # exit on failure

# Install APK: using adb root

$ADB root 2> /dev/null
$ADB remount # mount system
$ADB push $apk_host $apk_target_sys

# Give permissions
#$ADB pwd
# $ADB_SH "chmod 755 $apk_target_dir"
 $ADB_SH "chmod 775 $apk_target_sys"

#Unmount system
$ADB_SH "mount -o remount,ro /"

# Stop the app
$ADB shell "am force-stop $app_package"

# Re execute the app
# $ADB shell "am start -n \"$app_package/$app_package.$MAIN_ACTIVITY\" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER"
 $ADB shell am broadcast -a android.intent.action.BOOT_COMPLETED
