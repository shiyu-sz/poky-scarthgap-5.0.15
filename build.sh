#!/bin/bash

build_clean() {
    rm -rf build
}

build_env() {
    source oe-init-build-env build
    bitbake-layers add-layer ../meta-openembedded/meta-oe
    bitbake-layers add-layer ../meta-qt5
    bitbake-layers add-layer ../meta-my-app
}

build_app() {
    source oe-init-build-env build
    bitbake my-app-image
}

run_app() {
    source oe-init-build-env build
    export IMAGE_LINK_NAME=my-app-image-qemux86-64.rootfs  
    runqemu qemux86-64 serialstdio  
}

if test "$1" = "clean" ; then
    build_clean
elif test "$1" = "env" ; then
    build_env
elif test "$1" = "app" ; then
    build_app
elif test "$1" = "run" ; then
    run_app
fi
