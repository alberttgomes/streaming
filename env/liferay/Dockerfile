FROM liferay/dxp:7.4.13-u102

COPY --chown=liferay:liferay bundles/osgi/modules/*.jar /opt/liferay/osgi/modules
COPY --chown=liferay:liferay env/liferay/liferay-files /mnt/liferay/files
COPY --chown=liferay:liferay env/liferay/liferay-deploy /mnt/liferay/deploy
COPY --chown=liferay:liferay env/liferay/liferay-scripts /mnt/liferay/scripts