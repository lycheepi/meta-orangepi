require opipc-image.inc

SUMMARY = "Qt5 image for Orange Pi Pc"
IMAGE_LINGUAS = "en-us"

EXTRA = " \
  htop \
  gdb \
"

QT5_PKGS = " \
  qtbase \
  qtmultimedia \
  qt3d \
  qt5-opengles2-test \
  cinematicexperience \ 
"

IMAGE_INSTALL += " \
  packagegroup-core-buildessential \
  ${EXTRA} \
  ${QT5_PKGS} \
"

IMAGE_FEATURES += "x11"

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    splash \
    nfs-server \
    tools-debug \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"
CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
"
