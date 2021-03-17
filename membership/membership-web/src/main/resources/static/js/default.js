const base={
    baseUrl:'http://localhost:8081/api',
    chengpin:'/api/blueberrypai/getChengpinDetails.php',
    login:'/api/blueberrypai/login.php',
    music:"/sxtstu/music/baidu/list.php",
    login:'/api/login',
    list:'/api/list'
}

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.headers.common['tokenid'] = sessionStorage.getItem("tokenid");
axios.defaults.baseURL = base.baseUrl;
axios.defaults.timeout = 10000;
axios.interceptors.response.use(
    // 响应包含以下信息data,status,statusText,headers,config
    (res) => res.status === 200 ? Promise.resolve(res) : Promise.reject(res),
    (err) => {
        console.log(err)
        const { response } = err;
        // console.log(response)
        if (response) {
            errorHandle(response.status, response.data);
            return Promise.reject(response);
        } else {
            console.log('请求失败')
        }
    }
);
const errorHandle = (status, other) => {
    switch (status) {
        case 400:
            console.log("信息校验失败");
            break;
        case 401:
            console.log("认证失败");
            break;
        case 403:
            console.log("token校验失败");
            break;
        case 404:
            console.log("请求的资源不存在");
            break;
        case 500:
            console.log("500：访问服务失败");
            break;
        case 503:
            console.log("503：服务不可用");
            break;
        default:
            console.log(other);
            break;

    }
}
