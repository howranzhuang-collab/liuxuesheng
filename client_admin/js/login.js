// 滑动验证码核心逻辑 - 优化版
const banner = document.querySelector('.banner');
const blankBox = document.querySelector('.blank-box');
const block = document.querySelector('.block');
const moveBlock = document.querySelector('.move-block');
const moveP = document.querySelector('.move p'); // 用于提示文字

let isDragging = false;     // 是否正在拖拽
let startX = 0;             // 鼠标起始 X 坐标
let targetLeft = 0;         // 目标缺口左边距（正确位置）
window.k = false;           // 全局验证标志，供 index.html 使用

// 重置验证码函数（成功或失败后调用）
function resetCaptcha(success = false) {
    isDragging = false;
    block.style.left = '0px';
    moveBlock.style.left = '0px';
    window.k = success;

    if (success) {
        moveP.textContent = '验证成功 √';
        moveP.style.color = '#67c23a';
        moveBlock.style.background = '#67c23a';
        // 禁用进一步拖拽
        moveBlock.style.cursor = 'not-allowed';
    } else {
        moveP.textContent = '验证失败，请重试 ×';
        moveP.style.color = '#f56c6c';
        setTimeout(() => {
            refreshCaptcha();
        }, 1000);
    }
}

// 刷新验证码（重新生成缺口位置）
function refreshCaptcha() {
    const maxX = banner.offsetWidth - block.offsetWidth;
    const maxY = banner.offsetHeight - block.offsetHeight;

    // 随机生成缺口位置（避免太靠边）
    const ranX = Math.round(Math.random() * (maxX - 100) + 50);
    const ranY = Math.round(Math.random() * (maxY - 50) + 25);

    targetLeft = ranX;

    blankBox.style.left = ranX + 'px';
    blankBox.style.top = ranY + 'px';
    block.style.top = ranY + 'px';
    block.style.backgroundPosition = `-${ranX}px -${ranY}px`;

    // 重置滑块和提示
    moveBlock.style.left = '0px';
    block.style.left = '0px';
    moveP.textContent = '向右滑动完成验证 >>';
    moveP.style.color = '#666';
    moveBlock.style.background = '#1abc9c';
    moveBlock.style.cursor = 'pointer';
    window.k = false;
}

// 鼠标按下开始拖拽
moveBlock.onmousedown = function (e) {
    if (window.k) return; // 已验证成功，禁止再次拖拽

    const event = e || window.event;
    startX = event.clientX - block.offsetLeft;
    isDragging = true;
    moveBlock.style.transition = 'none'; // 拖拽时关闭动画
};

// 鼠标移动（绑定到 document 防止移出滑块失效）
document.onmousemove = function (e) {
    if (!isDragging) return;

    const event = e || window.event;
    let left = event.clientX - startX;

    const maxX = banner.offsetWidth - block.offsetWidth;
    if (left < 0) left = 0;
    if (left > maxX) left = maxX;

    block.style.left = left + 'px';
    moveBlock.style.left = left + 'px';

    // 判断是否对齐（容差 8px，更宽容用户体验）
    if (Math.abs(left - targetLeft) <= 8) {
        layer.msg('验证成功！', { icon: 1 });
        resetCaptcha(true);
        isDragging = false;
    }
};

// 鼠标松开
document.onmouseup = function () {
    if (!isDragging) return;

    // 判断是否成功
    const currentLeft = parseInt(block.style.left || 0);
    if (Math.abs(currentLeft - targetLeft) > 8) {
        layer.msg('验证失败', { icon: 2 });
        resetCaptcha(false);
    }
    // 成功的情况已在 mousemove 中处理
};

// 初始加载时生成一次验证码
refreshCaptcha();

// 可选：添加刷新按钮（推荐在 HTML 中加一个图标）
// 例如在 .move 下加 <span onclick="refreshCaptcha()" style="cursor:pointer;">↻</span>
