// 滑动验证码修复版 - 完美匹配你的原 HTML/CSS
const banner = document.querySelector('.banner');
const blankBox = document.querySelector('.blank-box');
const block = document.querySelector('.block');
const moveBlock = document.querySelector('.move-block');
const moveP = document.querySelector('.move p');

let isDragging = false;
let startX = 0;
let targetLeft = 0;
window.k = false; // 验证成功标志

// 刷新验证码（关键：重置所有位置和样式）
function refreshCaptcha() {
    // 重置滑块和拼图块到初始位置
    block.style.left = '0px';
    moveBlock.style.left = '0px';

    // 生成随机缺口位置（与你原版逻辑一致）
    const ranX = Math.round(Math.random() * (banner.offsetWidth - 100) + 0);
    const ranY = Math.round(Math.random() * (banner.offsetHeight - 50) + 25); // 避免太靠边

    targetLeft = ranX;

    // 设置缺口和拼图块位置
    blankBox.style.left = ranX + 'px';
    blankBox.style.top = ranY + 'px';
    block.style.top = ranY + 'px';
    block.style.backgroundPosition = '-' + ranX + 'px -' + ranY + 'px';

    // 重置提示和样式
    moveP.textContent = '向右滑动完成验证 >>';
    moveP.style.color = '#666';
    moveBlock.style.background = '#1abc9c';
    moveBlock.style.cursor = 'pointer';
    window.k = false;
}

// 开始拖拽
moveBlock.onmousedown = function (e) {
    if (window.k) return; // 已成功禁止再拖

    e.preventDefault();
    startX = e.clientX - parseInt(block.style.left || 0);
    isDragging = true;
};

// 拖拽移动（绑定 document 防止移出失效）
document.onmousemove = function (e) {
    if (!isDragging) return;

    let left = e.clientX - startX;
    const maxX = banner.offsetWidth - block.offsetWidth;

    if (left < 0) left = 0;
    if (left > maxX) left = maxX;

    // 同步移动拼图块和滑块
    block.style.left = left + 'px';
    moveBlock.style.left = left + 'px';

    // 实时判断成功（容差 8px）
    if (Math.abs(left - targetLeft) <= 8) {
        layui.use('layer', () => layui.layer.msg('验证成功！', {icon: 1}));
        window.k = true;
        moveP.textContent = '验证成功 √';
        moveP.style.color = '#67c23a';
        moveBlock.style.background = '#67c23a';
        moveBlock.style.cursor = 'not-allowed';
        isDragging = false;
    }
};

// 松开鼠标
document.onmouseup = function () {
    if (!isDragging) return;

    const currentLeft = parseInt(block.style.left || 0);

    if (Math.abs(currentLeft - targetLeft) > 8) {
        layui.use('layer', () => layui.layer.msg('验证失败，请重试', {icon: 2}));
        setTimeout(refreshCaptcha, 800); // 失败后自动刷新
    }
    // 成功已在 mousemove 处理
};

// 页面加载时初始化验证码
refreshCaptcha();

// 暴露刷新函数（可选，用于登录失败后调用）
window.refreshCaptcha = refreshCaptcha;
