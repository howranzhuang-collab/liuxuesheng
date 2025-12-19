function baseUrl() {
    // 生产环境：使用相对路径（推荐，前端后端同域部署）
    // return ''; // 或 return '/';

    // 开发环境：本地跨域
    // 判断当前是否是本地开发
    if (location.hostname === 'localhost' || location.hostname === '127.0.0.1') {
        return 'http://127.0.0.1:5000';
    }

    // 生产环境：相对路径（前后端同域名）
    return '';
}
