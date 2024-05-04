
const uri = {
    protocol: "https://",
    hostName: "apigardeningguizkev-production.up.railway.app/",
    path: "api/"
};

const uri_main = `${uri.protocol + uri.hostName + uri.path}`;

const uri_main_x_path = (path) => {
    return `${uri.protocol + uri.hostName + uri.path + path}`;
}

export { uri_main_x_path };
