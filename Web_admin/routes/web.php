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
Route::get('/register', function () {
    return view('layouts.register');
});
Route::get('/layouts/index', function () {
    return view('layouts.index');
});
Route::get('/data/data_khachhang', function () {
    return view('data.data_khachhang');
});
Route::get('/data/data_ve', function () {
    return view('data.data_ve');
});
Route::get('/data/data_dsve', function () {
    return view('data.data_dsve');
});
Route::get('/data/data_rap', function () {
    return view('data.data_rap');
});
Route::get('/data/data_ghe', function () {
    return view('data.data_ghe');
});
Route::get('/data/data_gia', function () {
    return view('data.data_gia');
});
Route::get('/data/data_loaighe', function () {
    return view('data.data_loaighe');
});
Route::get('/data/data_phim', function () {
    return view('data.data_phim');
});
Route::get('/data/data_theloaiphim', function () {
    return view('data.data_theloaiphim');
});
Route::get('/data/data_dinhdangphim', function () {
    return view('data.data_dinhdangphim');
});
Route::get('/data/data_trangthaiphim', function () {
    return view('data.data_trangthaiphim');
});
Route::get('/data/data_lichchieu', function () {
    return view('data.data_lichchieu');
});
Route::get('/data/data_suatchieu', function () {
    return view('data.data_suatchieu');
});
Route::get('/data/data_taikhoan', function () {
    return view('data.data_taikhoan');
});
Route::get('/data/data_binhluan', function () {
    return view('data.data_binhluan');
});
Route::get('/data/them_khachhang', function () {
    return view('data.them_khachhang');
});
Route::get('/data/them_lichchieu', function () {
    return view('data.them_lichchieu');
});
Route::get('/data/them_suatchieu', function () {
    return view('data.them_suatchieu');
});
Route::get('/data/them_rap', function () {
    return view('data.them_rap');
});
Route::get('/data/them_ghe', function () {
    return view('data.them_ghe');
});
Route::get('/data/them_loaighe', function () {
    return view('data.them_loaighe');
});
Route::get('/data/them_gia', function () {
    return view('data.them_gia');
});
Route::get('/data/them_ve', function () {
    return view('data.them_ve');
});
Route::get('/data/them_dsve', function () {
    return view('data.them_dsve');
});
Route::get('/data/them_binhluan', function () {
    return view('data.them_binhluan');
});
Route::get('/data/them_taikhoan', function () {
    return view('data.them_taikhoan');
});
Route::get('/data/them_phim', function () {
    return view('data.them_phim');
});
Route::get('/data/them_trangthaiphim', function () {
    return view('data.them_trangthaiphim');
});
Route::get('/data/them_theloaiphim', function () {
    return view('data.them_theloaiphim');
});
Route::get('/data/them_dinhdangphim', function () {
    return view('data.them_dinhdangphim');
});
Route::get('/data/sua_khachhang', function () {
    return view('data.sua_khachhang');
});
Route::get('/data/sua_lichchieu', function () {
    return view('data.sua_lichchieu');
});
Route::get('/data/sua_suatchieu', function () {
    return view('data.sua_suatchieu');
});
Route::get('/data/sua_ve', function () {
    return view('data.sua_ve');
});
Route::get('/data/sua_dsve', function () {
    return view('data.sua_dsve');
});
Route::get('/data/sua_rap', function () {
    return view('data.sua_rap');
});
Route::get('/data/sua_ghe', function () {
    return view('data.sua_ghe');
});
Route::get('/data/sua_gia', function () {
    return view('data.sua_gia');
});
Route::get('/data/sua_loaighe', function () {
    return view('data.sua_loaighe');
});
Route::get('/data/sua_taiKhoan', function () {
    return view('data.sua_taiKhoan');
});
Route::get('/data/sua_phim', function () {
    return view('data.sua_phim');
});
Route::get('/data/sua_trangthaiphim', function () {
    return view('data.sua_trangthaiphim');
});
Route::get('/data/sua_theloaiphim', function () {
    return view('data.sua_theloaiphim');
});
Route::get('/data/sua_dinhdangphim', function () {
    return view('data.sua_dinhdangphim');
});
Route::get('/data/sua_binhluan', function () {
    return view('data.sua_binhluan');
});