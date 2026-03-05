SUMMARY = "Simple Qt5 Hello World Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# 包含 Qt5 的类，它会自动处理 qmake 编译
inherit qmake5

SRC_URI = " \
    file://qt-helloworld.pro \
    file://main.cpp \
    file://mainwindow.cpp \
    file://mainwindow.h \
    file://simhei.ttf \
"

S = "${WORKDIR}"

# 如果你的应用需要其他 Qt 模块，可以在这里添加
DEPENDS += "qtbase"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 qt-helloworld ${D}${bindir}
    install -d ${D}${libdir}
    install -m 0644 ${WORKDIR}/simhei.ttf ${D}${libdir}
}

FILES:${PN} += " \
    ${bindir}/qt-helloworld \
    ${libdir}/simhei.ttf \
"
