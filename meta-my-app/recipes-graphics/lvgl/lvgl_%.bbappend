# 1. 指定存放 lv_conf.h 的路径
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# 2. 将你的 lv_conf.h 加入源文件列表
SRC_URI:append = " file://lv_conf.h"

# 3. 核心修正：确保库在编译时能找到这个文件
# LVGL 9 默认在源码根目录寻找 lv_conf.h
do_configure:append() {
    cp ${WORKDIR}/lv_conf.h ${S}/lv_conf.h
}

# 4. 【至关重要】将这个配置文件安装到 sysroot
# 这样你的应用（demo）在编译时才能引用到完全一样的宏定义
do_install:append() {
    install -d ${D}${includedir}/lvgl
    install -m 0644 ${S}/lv_conf.h ${D}${includedir}/lvgl/lv_conf.h
}

# 2. 确保 PACKAGECONFIG 也开启了（处理源文件编译）
PACKAGECONFIG:append = " linux-fbdev linux-evdev"
