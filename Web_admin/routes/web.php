<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
Route::get('/', function () {
    return view('layouts.login');
});
Route::get('/index', function () {
    return view('layouts.index');
});

Route::group(['prefix'=>'ve'], function(){

    Route::get('/data_ve', function () {
    return view('data.Trang_Ve.data_ve');
    });

    Route::get('/sua_ve', function () {
    return view('data.Trang_Ve.sua_ve');
    });
});
Route::group(['prefix'=>'ds_ve'], function(){
    
    Route::get('/data_dsve', function () {
    return view('data.Trang_DanhSachVe.data_dsve');
    });

    Route::get('/sua_dsve', function () {
    return view('data.Trang_DanhSachVe.sua_dsve');
    });
});
Route::group(['prefix'=>'rap'], function(){
    
    Route::get('/data_rap', function () {
    return view('data.Trang_Rap.data_rap');
    });

    Route::get('/them_rap', function () {
    return view('data.Trang_Rap.them_rap');
    });

    Route::get('/sua_rap', function () {
    return view('data.Trang_Rap.sua_rap');
    });
});
Route::group(['prefix'=>'ghe'], function(){
    
    Route::get('/data_ghe', function () {
    return view('data.Trang_Ghe.data_ghe');
    });

    Route::get('/them_ghe', function () {
    return view('data.Trang_Ghe.them_ghe');
    });

    Route::get('/sua_ghe', function () {
    return view('data.Trang_Ghe.sua_ghe');
    });
});
Route::group(['prefix'=>'gia'], function(){
    
    Route::get('/data_gia', function () {
    return view('data.Trang_Gia.data_gia');
    });

    Route::get('/them_gia', function () {
    return view('data.Trang_Gia.them_gia');
    });

    Route::get('/sua_gia', function () {
    return view('data.Trang_Gia.sua_gia');
    });
});
Route::group(['prefix'=>'loaighe'], function(){

    Route::get('/data_loaighe', function () {
    return view('data.Trang_LoaiGhe.data_loaighe');
    });

    Route::get('/them_loaighe', function () {
    return view('data.Trang_LoaiGhe.them_loaighe');
    });

    Route::get('/data/sua_loaighe', function () {
    return view('data.Trang_LoaiGhe.sua_loaighe');
    });
});
Route::group(['prefix'=>'phim'], function(){
    
    Route::get('/data_phim', function () {
    return view('data.Trang_Phim.data_phim');
    });
    
    Route::get('/them_phim', function () {
    return view('data.Trang_Phim.them_phim');
    });
    
    Route::get('/sua_phim', function () {
    return view('data.Trang_Phim.sua_phim');
    });
});
Route::group(['prefix'=>'theloaiphim'], function(){

    Route::get('/data_theloaiphim', function () {
    return view('data.Trang_TheLoaiPhim.data_theloaiphim');
    });

    Route::get('/them_theloaiphim', function () {
    return view('data.Trang_TheLoaiPhim.them_theloaiphim');
    });
    
    Route::get('/sua_theloaiphim', function () {
    return view('data.Trang_TheLoaiPhim.sua_theloaiphim');
    });
});
Route::group(['prefix'=>'dinhdangphim'], function(){

    Route::get('/data_dinhdangphim', function () {
    return view('data.Trang_DinhDangPhim.data_dinhdangphim');
    });

    Route::get('/them_dinhdangphim', function () {
    return view('data.Trang_DinhDangPhim.them_dinhdangphim');
    });
    
    Route::get('/sua_dinhdangphim', function () {
    return view('data.Trang_DinhDangPhim.sua_dinhdangphim');
    });
});
Route::group(['prefix'=>'trangthaiphim'], function(){

    Route::get('/data_trangthaiphim', function () {
    return view('data.Trang_TrangThaiPhim.data_trangthaiphim');
    });

    Route::get('/them_trangthaiphim', function () {
    return view('data.Trang_TrangThaiPhim.them_trangthaiphim');
    });
    
    Route::get('/sua_trangthaiphim', function () {
    return view('data.Trang_TrangThaiPhim.sua_trangthaiphim');
    });
});
Route::group(['prefix'=>'lichchieu'], function(){

    Route::get('/data_lichchieu', function () {
    return view('data.Trang_LichChieuPhim.data_lichchieu');
    });

    Route::get('/them_lichchieu', function () {
    return view('data.Trang_LichChieuPhim.them_lichchieu');
    });

    Route::get('/sua_lichchieu', function () {
    return view('data.Trang_LichChieuPhim.sua_lichchieu');
    });
});
Route::group(['prefix'=>'suatchieu'], function(){

    Route::get('/data_suatchieu', function () {
    return view('data.Trang_SuatChieu.data_suatchieu');
    });
    Route::get('/them_suatchieu', function () {
    return view('data.Trang_SuatChieu.them_suatchieu');
    });

    Route::get('/sua_suatchieu', function () {
    return view('data.Trang_SuatChieu.sua_suatchieu');
    });

});
Route::group(['prefix'=>'taikhoan'], function(){
    
    Route::get('/data_taikhoan', function () {
    return view('data.Trang_NguoiDung.data_taikhoan');
    });

    Route::get('/them_taikhoan', function () {
    return view('data.Trang_NguoiDung.them_taikhoan');
    });

    Route::get('/sua_taiKhoan', function () {
    return view('data.Trang_NguoiDung.sua_taiKhoan');
    });
});
Route::group(['prefix'=>'binhluan'], function(){
    
    Route::get('/data_binhluan', function () {
    return view('data.Trang_BinhLuan.data_binhluan');
    });
});


