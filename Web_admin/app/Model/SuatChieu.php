<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class SuatChieu extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];

    protected $fillable = [
    	'GioChieu',
		'Trangthai',
		'lichchieu_id'
    ];

    protected function lichchieu()
	{
		$this->belongsTo('Model\LichChieu','lichchieu_id');
	}
}
