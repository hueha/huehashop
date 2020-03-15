-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 15, 2020 lúc 04:01 PM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thoitrang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Quần', 'https://image.flaticon.com/icons/png/512/105/105992.png'),
(2, 'áo', 'https://lh3.googleusercontent.com/proxy/E6Y09OV-KNE24RcmwDB4DEXhPGph8tSMQl6cAoCDm1tFiksfQi2RhLu3RzW28csU-99pDvhxliCzJWxtnG3nZA5Kfsq6PuOkabnQX5jCzHe2E3hSMxWURs9N_v0c9orc'),
(3, 'Chân váy', 'https://cdn.nhanh.vn/cdn/store1/41822/pc/icon_338571_1568273450_ch%C3%A2n%20v%C3%A1y.png'),
(4, 'Váy', 'https://cdn.nhanh.vn/cdn/store/15249/pc/ps_cate_icon_1523435633_626.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idloaisanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idloaisanpham`) VALUES
(1, 'Quần bò màu khói', 150000, 'https://cf.shopee.vn/file/291000dd0c78ac421e27b5273725280c', 'quần bò khói xịn chất bao dày, bao đẹp', 1),
(2, 'Quần legging burmese l120', 179000, 'https://lanchicorset.vn/wp-content/uploads/2019/08/B%E1%BA%A3n-sao-c%E1%BB%A7a-B%E1%BA%A3n-sao-c%E1%BB%A7a-NAM_6863-1-600x902.jpg', 'Quần legging cạp cao với chát liệu 100% sợi tơ sen cực mềm, co dãn 4 chiều, nâng mông và giảm vòng eo,đùi cực kỳ hiệu quả', 1),
(3, 'Chân váy tennit', 99000, 'https://salt.tikicdn.com/cache/200x296/ts/product/b3/67/d9/6288355b56a6f83bbc57bd882ede63c2.jpg', 'chân váy phong cách đáng yêu, tôn dáng', 3),
(5, 'Chân váy lưng cao hoạ tiết caro thời trang cho nữ', 160000, 'https://cf.shopee.vn/file/868c6123c48392fbcdb4be53220966c0', '（Váy này có lớp lót，khóa kéo ở mặt bên）\r\n  Chất liệu Cotton + sợi polyester\r\n  Kích thước:\r\n  S: Chiều dài chân váy: 41cm, Eo: 68cm, Hông: 86cm.\r\n  M: Chiều dài chân váy: 42cm, Eo: 72cm, Hông: 90cm.\r\n  L: Chiều dài chân váy: 43cm, Eo: 76cm, Hông: 94cm.\r\n  XL: Chiều dài chân váy: 44cm, Eo: 80cm, Hông: 98cm.\r\n  2XL: Chiều dài chân váy: 45cm, Eo: 84cm, Hông: 102cm.\r\n  \r\n  Lưu ý:\r\n  * Vui lòng cho phép sai số kích thước trong khoảng 1-3cm do đo lường thủ công.\r\n  * Màu sắc thực có thể hơi khác so với hình ảnh do độ phân giải, độ sáng, độ tương phản của màn hình máy tính, vv. Hy vọng bạn sẽ thông cảm.\r\n  * Nếu bạn hài lòng với các sản phẩm và dịch vụ của chúng tôi, vui lòng để lại đánh giá 5 sao kèm theo ảnh. Trong trường hợp bạn không hài lòng với sản phẩm, vui lòng liên hệ ngay với chúng tôi, cảm ơn bạn!', 3),
(6, 'Váy tay dài màu trơn kiểu dáng đơn giản', 500000, 'https://media3.scdn.vn/img2/2018/12_7/xgYYUO_simg_de2fe0_500x500_maxb.jpg', 'Description：\r\n1.Polyester fiber comfy fabric,v neck super soft and breathable.\r\n2.Soft light weight material to keep you comfortable,super comfortable to your skin.very healthy and comfortable to wear.\r\n3.Women short sleeve v collar dress,dress sexy and elegant,knee-above length,classical button round neckline.\r\n4.Dress looks slim,nice to wear with elegant bra or tube tops underneath,along with a long necklace,sandals,high heels or boots.\r\n5.Please refer to the size chart below for details before purchasing to find out the details in the product description.\r\n6.Comfortable and breathable fabric, professional sewing technology, fine thread, washable and durable.\r\n7.It is also a good choice for your families and friends gifts.\r\n8.Machine washable. it is recommended to wash them before using them for the first time.Please refer to our size chart in product description before purchase.', 4),
(7, 'Áo Loang From rộng nữ', 59000, 'https://vn-test-11.slatic.net/p/b445f609e1a91ff1141197e748c862af.jpg_720x720q80.jpg_.webp', '❌ ❌Áo Loang Form Rộng Nữ ❌❌❌\r\n✌️Hè đến ko diện phông thì diện gì bây giờ nhỉ :)))\r\n✌️Chất mềm, co dãn tốt, đặc biệt là siu mát ạ...form áo dáng chuẩn đẹp lun <3\r\n✌️Thêm một lợi thế của e áo này là mix với gì cũng xinh, mặc đi đâu cũng hợp. Mix với sooc, chân váy, quần jean... mặc đi chơi, ở nhà, đi làm đều được => xứng đáng là một món đồ #must_have trong tủ đồ của mỗi chị em nhà mình <3\r\n?Freesize dưới 60kg đẹp\r\n✌️Nhanh tay thêm ngay vào giỏ hàng để nhận ưu đãi của shop nhaaaa ce <3', 2),
(8, 'Áo tiểu thư ulzzang gài nút ren xinhh yêu', 179000, 'https://vn-test-11.slatic.net/p/14f3b58a8bde66a3717379bb2edc638f.jpg_720x720q80.jpg_.webp', 'Chất liệu: kate', 2),
(9, 'ÁO NỈ IN HÌNH KHỦNG LONG dáng rộng Ulzzang', 590, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQytWabQfg9ZvNrYB8tMA0AtX1Wo6cRGve2o_2SWYx9f4Fxk-8o', 'ÁO nỉ khủng long \r\nChất liệu : nỉ bông mỏng mềm mịn , rất thích hợp để mặc cho mùa đông không lạnh như năm nay \r\nKiểu dáng : với thiết kế basic cổ tròn dài tay phối hình in những chú khủng long nhỏ đáng yêu , hình in công nghệ mới sắc nét sịn sò , phần tay và phần đuôi bo nẹp nhẹ tạo nét bồng , với sắc  màu tươi tắn  sẽ làm cho chị em nổi bật trong đám đông , em này có thể mix thoải mái đều rất xinh \r\nMàu sắc : vàng , xanh than \r\nForm : freesize , dài 65cm , V1< 110 . Tầm 60kg đổ lại mặc rất xinh \r\nSỉ sll ib để được giá đẹp nha \r\n#ao #aokieu #aokhunglong  #aoxinh #aoulzzang #aodoi #aobasic #aothoitrang #thoitrang #thoitrangnu #shopee #shopeevn #khoac #bomber #unisex', 2),
(10, 'Áo Kiểu Bo Eo Thắt Nơ Sau', 150000, 'https://cf.shopee.vn/file/5ec12f715a61d8fba9794389c9167645', 'Chất liệu :  Voan Mềm , Mịn Thích Hợp Với Các Bạn Nữ Dưới 55kg \r\n•Kiểu Dáng Đơn Giản , Trẻ Trung \r\n• Đi Học , Đi Chơi , Đi Dạo Mặc Đều Ok', 2),
(11, 'áo kiểu cổ V tay dài bo xinh kèm ảnh thật', 179000, 'https://cf.shopee.vn/file/97cf848e796377c638b731ed2dd0cc15', 'Mẫu mới đẹp cho mấy nàng \r\n? CHẤT LIỆU : kate đẹp dễ mặc\r\n? MÀU SẮC : dễ thương\r\n? Fom chuẩn đẹp : 80-90% chiều cao dưới  1m53\r\n?FREE SIZE:  dưới 50 kg mặc vừa đẹp\r\n**Tôn Fom dáng, đường may kĩ, hàng y hình 80 - 90%\r\n**Thích hợp, mặc nhà, dạo phố, picnic...\r\n**Mẫu mã đẹp, hợp thời trang. Shop luôn cập nhật mẫu mới thường xuyên. \r\n?Hàng rất mau hết nên nhanh tay đặt hàng nhé khách yêu.\r\n☘ HÀNG CHUẨN- DÁNG XINH- TỰ TIN XUỐNG PHỐ\r\n?BAO GIÁ CẠNH TRANH TOÀN QUỐC. \r\n***Hàng đảm bảo UY TÍN, CHẤT LƯỢNG\r\n***Lưu Ý: màu sắc, kiểu dáng có thể chênh lệch khoảng 10%-20% do độ phân giải màu sắc màn hình khi chụp và hình người mẫu mặc, nhưng chất lượng luôn đảm bảo.', 2),
(12, 'Áo thun lụa tay ngắn có cổ phối khoá kéo', 99000, 'https://cf.shopee.vn/file/5102b47db853116c852fc787a4d2e56f', 'Mẫu mới đẹp cho mấy nàng \r\n? CHẤT LIỆU : thun lụa đẹp dễ mặc\r\n? MÀU SẮC : dễ thương\r\n? Fom đẹp y hình:  80-90%\r\n?FREE SIZE:  dưới 50 kg mặc vừa đẹp \r\n                         chiều cao dưới  1m55\r\n**Tôn Fom dáng, hàng y hình 80 - 90%\r\n**Thích hợp, mặc nhà, dạo phố, picnic...\r\n**Mẫu mã đẹp, hợp thời trang. Shop luôn cập nhật mẫu mới thường xuyên. \r\n?Hàng rất mau hết nên nhanh tay đặt hàng nhé khách yêu.\r\n☘ HÀNG CHUẨN- DÁNG XINH- TỰ TIN XUỐNG PHỐ\r\n?BAO GIÁ CẠNH TRANH TOÀN QUỐC. \r\n***Hàng đảm bảo UY TÍN lâu dài\r\n***Lưu Ý: \r\n---- Không so sánh với ảnh người mẫu mặc\r\n--- đặt sai màu, đổi size, sai thông tin, vui lòng huỷ đi đặt lại, shop không chấp nhận để lại ghi chú.\r\n---- màu sắc, kiểu dáng có thể chênh lệch khoảng 10%-20% do độ phân giải màu sắc màn hình khi chụp và hình người mẫu mặc, nhưng chất lượng luôn đảm bảo.', 2),
(13, 'Áo thun gân cổ cao tay dài xẻ vai', 199000, 'https://cdn.shopify.com/s/files/1/2172/8265/products/ao-thun-gan-xe-vai-croptop-ho-eo-thoi-trang-bt-fashion-at058trang-1482479462-2724933-21a6984ad3a2acb142097adb9af4136f-zoom_850x850_12d80f3f-9c40-4f', 'Mẫu mới đẹp cho mấy nàng \r\n? CHẤT LIỆU : thun gân đẹp dễ mặc\r\n? MÀU SẮC : dễ thương\r\n? Fom đẹp y hình:  80-90%\r\n?FREE SIZE:  dưới 50 kg mặc vừa đẹp \r\n                         chiều cao dưới  1m55\r\n**Tôn Fom dáng, hàng y hình 80 - 90%\r\n**Thích hợp, mặc nhà, dạo phố, picnic...\r\n**Mẫu mã đẹp, hợp thời trang. Shop luôn cập nhật mẫu mới thường xuyên. \r\n?Hàng rất mau hết nên nhanh tay đặt hàng nhé khách yêu.\r\n☘ HÀNG CHUẨN- DÁNG XINH- TỰ TIN XUỐNG PHỐ\r\n?BAO GIÁ CẠNH TRANH TOÀN QUỐC. \r\n***Hàng đảm bảo UY TÍN lâu dài\r\n***Lưu Ý: \r\n---- Không so sánh với ảnh người mẫu mặc\r\n--- đặt sai màu, đổi size, sai thông tin, vui lòng huỷ đi đặt lại, shop không chấp nhận để lại ghi chú.\r\n---- màu sắc, kiểu dáng có thể chênh lệch khoảng 10%-20% do độ phân giải màu sắc màn hình khi chụp và hình người mẫu mặc, nhưng chất lượng luôn đảm bảo.', 2),
(14, 'áo nữ tay lưới dài ống bo kiểu nhúm trễ vai kèm ảnh thật cuối hình', 149000, 'https://cf.shopee.vn/file/0a117b20e9738536ed2948ce2b11b5a6', 'Mẫu mới đẹp cho mấy nàng \r\n? CHẤT LIỆU : kate+lưới đẹp dễ mặc\r\n? MÀU SẮC : dễ thương\r\n? Fom đẹp y hình:  80-90%\r\n?FREE SIZE:  dưới 50 kg mặc vừa đẹp \r\n                         chiều cao dưới  1m55\r\n**Tôn Fom dáng, hàng y hình 80 - 90%\r\n**Thích hợp, mặc nhà, dạo phố, picnic...\r\n**Mẫu mã đẹp, hợp thời trang. Shop luôn cập nhật mẫu mới thường xuyên. \r\n?Hàng rất mau hết nên nhanh tay đặt hàng nhé khách yêu.\r\n☘ HÀNG CHUẨN- DÁNG XINH- TỰ TIN XUỐNG PHỐ\r\n?BAO GIÁ CẠNH TRANH TOÀN QUỐC. \r\n***Hàng đảm bảo UY TÍN lâu dài\r\n***Lưu Ý: \r\n---- Không so sánh với ảnh người mẫu mặc\r\n--- đặt sai màu, đổi size, sai thông tin, vui lòng huỷ đi đặt lại, shop không chấp nhận để lại ghi chú.\r\n---- màu sắc, kiểu dáng có thể chênh lệch khoảng 10%-20% do độ phân giải màu sắc màn hình khi chụp và hình người mẫu mặc, nhưng chất lượng luôn đảm bảo.', 2),
(15, 'áo sát lách mặc được 2 kiểu trước sau xinh tươi', 200000, 'https://img.sosanhgia.com/images/150x0/32b3249cf70b495d91fec2781377f883/ao-sat-lach-mac-duoc-2-kieu-truoc-sau-xinh-tuoi.jpeg', 'Mẫu mới đẹp cho mấy nàng \r\n? CHẤT LIỆU : kate đẹp dễ mặc\r\n? MÀU SẮC : dễ thương\r\n? Fom chuẩn đẹp y hình:  80-90% chiều cao dưới  1m53\r\n?FREE SIZE:  dưới 50 kg mặc vừa đẹp\r\n**Tôn Fom dáng, đường may kĩ, hàng y hình 80 - 90%\r\n**Thích hợp, mặc nhà, dạo phố, picnic...\r\n**Mẫu mã đẹp, hợp thời trang. Shop luôn cập nhật mẫu mới thường xuyên. \r\n?Hàng rất mau hết nên nhanh tay đặt hàng nhé khách yêu.\r\n☘ HÀNG CHUẨN- DÁNG XINH- TỰ TIN XUỐNG PHỐ\r\n?BAO GIÁ CẠNH TRANH TOÀN QUỐC. \r\n***Hàng đảm bảo UY TÍN, CHẤT LƯỢNG\r\n***Lưu Ý: màu sắc, kiểu dáng có thể chênh lệch khoảng 10%-20% do độ phân giải màu sắc màn hình khi chụp và hình người mẫu mặc, nhưng chất lượng luôn đảm bảo.', 2),
(16, 'Váy thụng trơn dài tay kèm đai', 150000, 'https://cf.shopee.vn/file/652d41ead6f68a0b6e0948f97a3b0161', 'Sản phẩm bên shop chủ yếu là free size\r\nNữ 40 - 55kg đổ về \r\nNam 65kg đổ về\r\nNgoài ra còn có rất nhiều mẫu quần áo 4 mùa giá tại xưởng không qua trung gian ....\r\nKhách Yêu lấy số lượng cắt giá đẹp inbox hoặc add #zalo: 0963247883 \r\n?? Nhận in áo #Nhóm, #Lớp \r\n#Áosơmi #áothun # quầnkaki #Unisex\r\n#Yếmkaki #quầnyếm #áophảnquang\r\nĐịa chỉ : xã  Mỹ Phúc - Mỹ Lộc - Nam Định\r\nVáy trơn kèm đai\r\nChất thun , da cá \r\nSản phẩm như ảnh trùng nên m7 mặc cũng k lo lộ nhá\r\n4 màu vàng trắng đen tàn', 4),
(17, 'Đầm kate Nhật phối tay voan V1337', 400000, 'https://thoitrangtadi.com/wp-content/uploads/2020/02/dam-thiet-ke-mau-nau-phoi-tay-voan-v1337.jpg', 'SẢN PHẨM VÁY ĐẦM THIẾT KẾ ĐẾN TỪ THƯƠNG HIỆU THỜI TRANG THIẾT KẾ CAO CẤP ĐỘC QUYỀN DOLCE VIVA COLLECTION\r\nVáy đầm thiết kế cao cấp cắt tay, may thủ công với chất vải nhập khẩu từ Mỹ, váy đầm chuẩn form, chuẩn dáng, với các size cắt sẵn, chỉ cần quý khách hàng phù hợp chiều cao cân nặng sẽ lên chuẩn dáng như may đo. Chúng tôicam kết là loại chất liệu tốt nhất với tầm cùng giá trên thị trường. \r\n1.	Giới thiệu về váy đầm thiết kế V1337\r\nHot trend: Là chiếc váy đầm hợp model và xu thế thời trang nhất thời điểm hiện tại.\r\n\r\nThiết kế đặc biệt: Với thiết kế theo phong cách nhẹ nhàng, đơn giản, chiếc váy đầm V1337 của chúng tôi sẽ mang đến cho quý khách hàng cảm giác đặc biệt khi mặc và sự tự tin cần thiết của một QUÝ CÔ. Phong cách thiết kế của chúng tôi có thể sử dụng trong thời gian dài mà không lỗi mốt, số lượng mẫu mã váy đầm thiết kế phong phú và vô cùng đa dạng.\r\n\r\nMàu sắc: được lựa chọn bởi các nhà thiết kế hàng đầu Việt Nam nên màu sắc của chiếc váy đầm thiết kế V1337mang phong cách trẻ trung, thời thượng, tôn dáng và vô cùng tôn da.\r\n\r\nƯu điểm của váy đầm thiết kếV1337 : \r\n-  Chất vải: mềm mịn, thấm hút mồ hôi, không bai, không xù, không dão.\r\n\r\n- Form dáng: Chiếc váy đầm của chúng tôi nhìn, có thể không thấy sang trọng, nhìn có thể chưa biết form dáng ra sao nhưng chúng tôi đảm bảo khi quý khách mặc những chiếc váy đầm thiết kế của chúng tôi, quý khách hàng sẽ thật sự hiểu như thế nào là chuẩn form dáng, bởi chỉ cần đúng size, thiết kế gần như khít như may cho riêng bạn vậy. \r\n\r\n- Sự chân thật: Toàn bộ váy đầm thiết kế đều có ảnh thật trải sàn do shop tự chụp. Có video quay cận cảnh chất vải. Khách hang nhắn tin cho shop để nhận thêm video hoặc ảnh nếu cần them thông tin chi tiết.\r\n\r\n- Công dụng tuyệt vời:Váy đầm thiết kế V1337 phù hợp với nhiều không gian cho các nàng: đi tiệc, đi làm công sở, dạo phố, đi biển đều phù hợp .\r\n', 4),
(18, 'Đầm 2 dây ngọc lụa cao cấp trắng V1095', 300000, 'https://cf.shopee.vn/file/ceea916006dcc9bf3abd74c4f808fb2f', 'SẢN PHẨM VÁY ĐẦM THIẾT KẾ ĐẾN TỪ THƯƠNG HIỆU THỜI TRANG THIẾT KẾ CAO CẤP ĐỘC QUYỀN DOLCE VIVA COLLECTION\r\nVáy đầm thiết kế cao cấp cắt tay, may thủ công với chất vải nhập khẩu từ Mỹ, váy đầm chuẩn form, chuẩn dáng, với các size cắt sẵn, chỉ cần quý khách hàng phù hợp chiều cao cân nặng sẽ lên chuẩn dáng như may đo. Chúng tôi cam kết là loại chất liệu tốt nhất với tầm cùng giá trên thị trường. \r\n1. Giới thiệu về váy đầm thiết kế DVC\r\nHot trend: Là chiếc váy đầm hợp model và xu thế thời trang nhất thời điểm hiện tại.\r\n\r\nThiết kế đặc biệt: Với thiết kế theo phong cách nhẹ nhàng, đơn giản, chiếc váy đầm DVC của chúng tôi sẽ mang đến cho quý khách hàng cảm giác đặc biệt khi mặc và sự tự tin cần thiết của một QUÝ CÔ. Phong cách thiết kế của chúng tôi có thể sử dụng trong thời gian dài mà không lỗi mốt, số lượng mẫu mã váy đầm thiết kế phong phú và vô cùng đa dạng.\r\n\r\nMàu sắc: được lựa chọn bởi các nhà thiết kế hàng đầu Việt Nam nên màu sắc của chiếc váy đầm thiết kế DVC  mang phong cách trẻ trung, thời thượng, tôn dáng và vô cùng tôn da.\r\n\r\nƯu điểm của váy đầm thiết kế DVC : \r\n-  Chất vải:  mềm mịn, thấm hút mồ hôi, không bai, không xù, không dão.\r\n\r\n- Form dáng: Chiếc váy đầm của chúng tôi nhìn, có thể không thấy sang trọng, nhìn có thể chưa biết form dáng ra sao nhưng chúng tôi đảm bảo khi quý khách mặc những chiếc váy đầm thiết kế của chúng tôi, quý khách hàng sẽ thật sự hiểu như thế nào là chuẩn form dáng, bởi chỉ cần đúng size, thiết kế gần như khít như may cho riêng bạn vậy. \r\n\r\n- Sự chân thật: Toàn bộ váy đầm thiết kế đều có ảnh thật trải sàn do shop tự chụp. Có video quay cận cảnh chất vải. Khách hang nhắn tin cho shop để nhận thêm video hoặc ảnh nếu cần them thông tin chi tiết.\r\n\r\n- Công dụng tuyệt vời: Váy đầm thiết kế DVC phù hợp với nhiều không gian cho các nàng: đi tiệc, đi làm công sở, dạo phố, đi biển đều phù hợp .\r\n\r\n2. Thông số thiết kế của váy đầm DVC\r\na. Chất liệu: vải nhập khẩu Mỹ\r\nb. Size váy:\r\n- Chiều cao và cân nặng: \r\n                           Size S:   từ 40kg - 49kg\r\n                           Size M: từ 49kg - 54kg\r\n                           Size L:   từ 54kg - 62kg\r\n                           (Tùy thuộc vào chiều cao)\r\n- Vòng eo: \r\n                           Size S: 54 - 68\r\n                           Size M: 68 - 74\r\n                           Size L: 74 - 83\r\n3. Hướng dẫn sử dụng : \r\n- Giặt máy ở chế độ máy nhẹ nhàng \r\n- Giặt tay không vắt \r\n- Là ở chế độ phù hợp \r\n\r\n\r\n\r\n4. Thông tin liên hệ mua sỉ lẻ váy đầm thiết kế \r\nSố hotline: 0902 195 101\r\nShop để sỉ số lượng lớn váy đầm thiết kế cao cấp - không qua trung gian.\r\nSđt liên hệ sỉ : 0902195101, add zalo sỉ 0925773888\r\n', 4),
(19, 'Đầm đỏ dáng xòe tay lỡ bồng bềnh V825 Medushop kèm ảnh thật', 800000, 'https://cf.shopee.vn/file/71738830557c0b1e939791adef5a723d', 'SẢN PHẨM VÁY ĐẦM THIẾT KẾ ĐẾN TỪ THƯƠNG HIỆU THỜI TRANG THIẾT KẾ CAO CẤP ĐỘC QUYỀN DOLCE VIVA COLLECTION\r\nVáy đầm thiết kế cao cấp cắt tay, may thủ công với chất vải nhập khẩu từ Mỹ, váy đầm chuẩn form, chuẩn dáng, với các size cắt sẵn, chỉ cần quý khách hàng phù hợp chiều cao cân nặng sẽ lên chuẩn dáng như may đo. Chúng tôicam kết là loại chất liệu tốt nhất với tầm cùng giá trên thị trường. \r\n1.	Giới thiệu về váy đầm thiết kế V825\r\nHot trend: Là chiếc váy đầm hợp model và xu thế thời trang nhất thời điểm hiện tại.\r\n\r\nThiết kế đặc biệt: Với thiết kế theo phong cách nhẹ nhàng, đơn giản, chiếc váy đầm V825 của chúng tôi sẽ mang đến cho quý khách hàng cảm giác đặc biệt khi mặc và sự tự tin cần thiết của một QUÝ CÔ. Phong cách thiết kế của chúng tôi có thể sử dụng trong thời gian dài mà không lỗi mốt, số lượng mẫu mã váy đầm thiết kế phong phú và vô cùng đa dạng.\r\n\r\nMàu sắc: được lựa chọn bởi các nhà thiết kế hàng đầu Việt Nam nên màu sắc của chiếc váy đầm thiết kế V825mang phong cách trẻ trung, thời thượng, tôn dáng và vô cùng tôn da.\r\n\r\nƯu điểm của váy đầm thiết kếV825 : \r\n-  Chất vải: mềm mịn, thấm hút mồ hôi, không bai, không xù, không dão.\r\n\r\n- Form dáng: Chiếc váy đầm của chúng tôi nhìn, có thể không thấy sang trọng, nhìn có thể chưa biết form dáng ra sao nhưng chúng tôi đảm bảo khi quý khách mặc những chiếc váy đầm thiết kế của chúng tôi, quý khách hàng sẽ thật sự hiểu như thế nào là chuẩn form dáng, bởi chỉ cần đúng size, thiết kế gần như khít như may cho riêng bạn vậy. \r\n\r\n- Sự chân thật: Toàn bộ váy đầm thiết kế đều có ảnh thật trải sàn do shop tự chụp. Có video quay cận cảnh chất vải. Khách hang nhắn tin cho shop để nhận thêm video hoặc ảnh nếu cần them thông tin chi tiết.\r\n\r\n- Công dụng tuyệt vời:Váy đầm thiết kế V825 phù hợp với nhiều không gian cho các nàng: đi tiệc, đi làm công sở, dạo phố, đi biển đều phù hợp .\r\n\r\n2.	Thông số thiết kế của váy đầm V825\r\na.	Chất liệu: vải nhập khẩu Mỹ\r\nb.	Size váy:\r\n-	Chiều cao và cân nặng: \r\nSize S: từ 40kg-49kg\r\nSize M: từ 49kg-54kg\r\nSize L: từ 54kg-62kg\r\n(Tùy thuộc vào chiều cao)\r\n-	Vòng eo: \r\nSize S: 54 - 68\r\nSize M: 68 - 74\r\nSize L: 74 - 83\r\n3.	Hướng dẫn sử dụng : \r\n-	Giặt máy ở chế độ máy nhẹ nhàng \r\n-	Giặt tay không vắt \r\n-	Là ở chế độ phù hợp \r\n\r\n\r\n\r\n4.	Thông tin liên hệ mua sỉ lẻ váy đầm thiết kế \r\nSố hotline: 0902 195 101\r\nShop để sỉ số lượng lớn váy đầm thiết kế cao cấp - không qua trung gian.\r\nSđt liên hệ sỉ: 0902195101, add zalo sỉ 0925773888', 4),
(20, 'Đầm dự tiệc trắng tay phồng kết hạt siêu xinh', 150000, 'https://cf.shopee.vn/file/7ce61548fb4354c3a83dc8dc832da73e', 'Gin Dress \r\n? Tone trắng luôn là nhất\r\n? Quá chuẩn cho buổi tiệc tùng, hẹn hò \r\n? Tay bồng đính hạt, xinh lắm ớ\r\nChất liệu: Cotton mỹ\r\nSize XS S M L XL\r\nSize XS dưới 42kg, 3 vòng 80 60 85\r\nSize S dưới 48kg, 3 vòng 85 65 90 \r\nSize M dưới 52kg, 3 vòng 90 70 95\r\nSize L dưới 57kg, 3 vòng 95 75 100\r\nSize XL dưới 60kg, 3 vòng 100 80 105\r\nNếu thắc mắc về size cứ ib shop hỏi nhé, còn nếu bạn đã đo đúng số đo thì cứ đặt hàng bên mình nhận được đơn sẽ gửi hàng ngay lập tức bạn cứ yên tâm nha.\r\n\r\n#váyxinh #váyđầm #váyxòe #dambody #damdutiec #freeship #damxinh #dambody #damom #BLUEE', 4),
(21, 'Đầm xoè phối lưới nhũ đính hạt/ đầm dự tiệc', 700000, 'https://cf.shopee.vn/file/9f1e472f0f1beed7689dcad4626fd2e9', '??ĐẦM XOÈ TAY LƯỚI NHŨ ĐÍNH HẠT??\r\n➖Chất liệu: thun nhung+ lưới nhũ (lót đúp 2 lớp) + đính HẠT\r\n➖Màu:\r\n▶️Đỏ đô: tay lưới nude đóng hạt nude\r\n▶️Trắng: tay lưới trắng đóng hạt trắng\r\n▶️Đen: tay lưới nude đóng hạt nude\r\n➖Freesize: chất co giãn tốt, fix được S/M/L\r\n? GIA: 2️⃣2️⃣5️⃣。0️⃣0️⃣0️⃣\r\n\r\n#ngocthai #thaikimngoc #đầm #váy #xoè #đầmxoè #đầmcôngsở #đầmxinh #đầmdựtiệc #đầmtiệc #cưới #đầmváy\r\n\r\n#đầmtrắng #damtrang #vaytrang #váytrắng', 4),
(22, 'Chân váy tutu công chúa hình thật kèm clip', 99000, 'https://cf.shopee.vn/file/21869b711ee3d6177d28bac60ff81ac9', 'Chào mừng quý khách đến với ulzzang store\r\nShop có đăng tải hinh sp đính kèm . Khách yêu kéo qua mấy ảnh sau xem nhé \r\nKHÁCH HÀNG LƯU Ý . HÀNG BÊN EM CHUẨN PHỒNG LƯỚI TỰ NHIÊN . DÀI CHUẨN 65CM NHÉ . CHẤT DÀY ĐẸP .\r\nFREE SIZE DƯỚI 60 KG ĐAI CHUN RẤT DỄ PHỐI . \r\nChất liệu: lưới phồng và 1 lớp lót bên trong nha khách ( LỚP LÓT DÀY DẶN ĐẢM BẢO KO BỊ LỘ ) SHOP CÓ NHIỀU SỰ LỰA CHỌN ĐAI LƯNG CHO KHÁCH NHÉ . \r\n?? HÌNH THẬT VÀ CLIP SHOP ĐÃ ĐÍNH KÈM . HÀNG RẤT ĐẸP KHÁCH VUI LÒNG KHÔNG ĐÒI XEM HÀNG DÙM SHOP VÌ QUY ĐỊNH CỦA SHOPEE . \r\nCAM KẾT HÀNG Y ẢNH THẬT CHỤP VÀ CLIP 100% \r\nSHOP ULZZANG BAO GIÁ LẺ VÁY NÀY TRÊN TOÀN SÀN SHOPEE VÌ EM BÁN GIÁ RẺ NHẤT RỒI . CÁC BẠN RA SHOP KO DƯỚI 70_80K 1 VÁY ĐÂU Ạ . HÀNG BÊN E PHỒNG ĐẸP TỰ NHIÊN . \r\n## LƯU Ý : HÀNG NHÀ MAY KHÔNG PHẢI HÀNG QUẢNG CHÂU NHA KHÁCH . \r\nVáy dài 65 cm nhé khách . Qua gối ạ. \r\nMọi thắc mắc khách liên hệ với bên em trong mục chat để được tư vấn nhé', 3),
(23, 'Chân Váy Xếp ly Kaki đen Chữ A Dáng ngắn Váy', 80000, 'https://cf.shopee.vn/file/fdfeadba263dce3baf5a8908745a34a9', 'Luôn là nơi cập nhật những xu hướng mới, chúng tôi đã khẳng định vị trí của mình với nhiều bạn trẻ bởi phong cách thời trang sang trọng, thanh lịch nhưng không thiếu sự năng động và cá tính. Khéo léo kết hợp trang phục cùng phụ kiện, bạn dễ dàng mang lại một set đồ hài hòa, thể hiện được cá tính riêng của mình.\r\nDưới 55kg', 3),
(24, 'Chân Váy Xếp Ly Kaki Đen Chữ A Dáng Ngắn Váy Thiết Kế Xẻ Quyến Rũ', 300000, 'https://cf.shopee.vn/file/bac58321de388cca3e8a31517bc4fefc', '​​​​​​Chất liệu: kaki dày dặn Free size (43-55 kg tùy chiều cao nhé eo 80cm trở xuống mặc đẹp nè.Chất liệu mềm mại, co giãn và thấm hút mồ hôi tốt, form cực kỳ đẹp, mặc rất sang, tôn dáng.Đường may tinh tế, tỉ mỉ, chắc chắnCam kết hàng giống hình 100% (Lưu Ý : có quần trong)', 3),
(25, 'Chân váy kaki trơn ( có quần)', 90000, 'https://cf.shopee.vn/file/808ec37590723b616ed86f2437ce42da', 'Chân váy kaki trơn có quần\r\n⚘Chất liệu: kaki dày mịn (Cam kết vải dầy đẹp nha)\r\n⚘màu sắc: trắng, đen\r\n⚘size: S,M,L,XL ( nếu không chắc size thì ib chiều cao và cân nặng để mình tư vấn nhé)\r\n⚘Hàng có sẵn nhé! Mẫu này phải nói là rẻ mà rất rất đẹp có thể mặc đi làm hoặc đi chơi. Kiểu trơn đơn giản nên mình có thể phối với nhiều màu áo khác nhau', 3),
(26, 'QUẦN VÁY - QUẦN GIẢ VÁY', 69000, 'https://lh3.googleusercontent.com/proxy/giAtGSJix5U6VTbtZhgKbYzQC4WkQzT_VB20oKPkGBaL5qL9rfJbqxOQv_1ypgN_BMzSREgxxry77feFrfuuRK22dVSYDvniyHFD-cCmK6zjb_lo1eVefkuMo0aEi1xSP7JhzjStVx3-dh_6P5Xd44rjn6KTJ1rY', 'Cạp chun sau - trước khoá kéo +cúc cài đàng hoàng?\r\n? Em về trc chất sạn nha ce form dài rộg xinh như hình ?\r\n? freesize dưới 65kg ok (ib số đo shop tư vấn cụ thể chính xác nhất) ?', 1),
(27, 'VÁY QUẦN BIGSIZE HS303 -MÀU RÊU ,ĐEN,NUDE,TRẮNG,HỒNG-SIZE L,XL,XXL', 130000, 'https://cf.shopee.vn/file/f50beef4eb8e145cc5c42e306ffb77fb', '??Váy Quần ??\r\n✔️Chất :Tuyết mưa \r\n?Màu:rêu đen /đỏ/nude/Trắng/Hồng \r\n✔️H.à.n.g đẹp từg đươg  kim mủi chỉ \r\n ?Size L(eo 90 mong 100-105)\r\n        Size XL(eo 100 mong 110-115)\r\n          Size XXl( eo 105-110 mong 120-130)', 3),
(28, 'Chân váy xếp ly cạp cao có quần trong', 150000, 'https://cf.shopee.vn/file/73e6bcfbfe299b24b5262e4679f0cdd0', 'Chân váy xếp ly loại dài 40cm nhé không phải loại hàng may gia công ngắn nha\r\nSz L XL 2XL 3xl 4xl từ 50_85kg tùy chiều cao\r\nBẢNG SIZE THEO SỐ ĐO EO( các bạn lấy số đo trên rốn 2cm)\r\nSz L  tầm 51-57kg\r\nSz xl  tầm 58-62kg\r\nSz 2xl  tầm 61-67kg\r\nSz 3xl  tầm 68-75kg\r\nSz 4xl  tầm 75-85kg tùy chiều cao nữa nha', 3),
(29, 'Chân váy xòe dài', 199000, 'https://cf.shopee.vn/file/36ad21a6db880d6afe5f3e6858b2bb13', 'Dài váy 62cm. Qua gối nha\r\nBẢNG SIZE THEO SỐ ĐO EO( Eo là số đo trên rốn 4.5cm)\r\nSz L tầm dưới 57kg\r\nSz xl tầm dưới 63kg\r\nSz 2xl tầm dưới 70kg\r\nSz 3xl tầm dưới 77kg\r\nSz 4xl tầm dưới 90kg', 3),
(30, 'Quần nữ kaki túi hộp chun ống DHK678', 79000, 'https://cf.shopee.vn/file/af47524dcafe2fc063f05198ce205e72', '#quannudep  ? ?Mẫu Quần nữ của shop là hàng freesize\r\n?Chất liệu co giãn, phong cách mới tạo sức hút cho từng sản phẩm\r\n?Fom quần: nữ cao 1,62m 52kg trở lại là mặc đẹp nhé\r\n?Mẫu thiết kế màu như ảnh❤️❤️❤️❤️\r\n?Các sp của shop đa số đều có đăng kèm ảnh thật sp?\r\n?Khi đặt hàng các bạn đọc kỹ thông tin sp và đặt đơn với đúng màu và số lượng để tránh gửi hàng nhầm lẫn ạ.?\r\n?chất liệu sản phẩm kaki?', 1),
(31, 'Quần short nữ, shorts kaki lưng cao Quảng Châu QN17', 18900, 'https://cf.shopee.vn/file/2c879c3d45036bae9c872646e09be8de', 'Quần short nữ, shorts kaki lưng cao Quảng Châu QN17\r\nGiá lẻ: 215k\r\nGiá sỉ: 175k (Áp dụng khi mua từ 3SP bất kỳ, ib shop để được hướng dẫn nhé)\r\nSize: S,M,L\r\nKích cỡ size quần:\r\n(S) Eo : Mông : Dài = 66 : 88 : 44 cm\r\n(M) Eo : Mông : Dài = 70 : 92 : 45 cm\r\n(L) Eo : Mông : Dài = 74 : 96 : 46 cm\r\n(Số đo có thể chênh lệch do sai sót trong quá trình may,đo)\r\n* Quần thiết kế lưng cao, giúp tôn dáng, che bụng và tạo cảm giác cao ráo hơn khi mặc\r\n* Vải Kaki retro mềm mại, mặc rất thoải mái. Kaki Quảng Châu không giãn giúp giữ được dáng quần lâu hơn trong thời gian sử dụng\r\n* Hàng chất lượng loại 1, nhập trực tiếp từ xưởng Quảng Châu, không phải hàng gia công lại tại Việt Nam\r\n* Hình do xưởng chụp và Video do shop quay đều từ SP thật. Do ánh sáng khi chụp và chất lượng camera nên sẽ không thể lấy được 100% màu sắc quần thật sự bên ngoài, nhưng cũng mô tả được đúng 99% SP thật sự', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
