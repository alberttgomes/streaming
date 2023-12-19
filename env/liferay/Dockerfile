FROM liferay/dxp:7.4.13-u92

COPY --chown=liferay:liferay /bundles/osgi/modules/*.jar /opt/liferay/osgi/modules
COPY --chown=liferay:liferay /configs/docker/*.properties /mnt/liferay/files
COPY --chown=liferay:liferay /environment/liferay/liferay-deploy/ /mnt/liferay/deploy
COPY --chown=liferay:liferay /environment/liferay/liferay-files/.keep /mnt/liferay/files
COPY --chown=liferay:liferay /environment/liferay/liferay-scripts/ /mnt/liferay/scripts

